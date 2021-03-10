package kg.akoikelov.springmvcapp.controllers.superadmin;

import kg.akoikelov.springmvcapp.forms.CashBoxForm;
import kg.akoikelov.springmvcapp.mail.MailService;
import kg.akoikelov.springmvcapp.models.CashBox;
import kg.akoikelov.springmvcapp.services.AffiliateService;
import kg.akoikelov.springmvcapp.services.AnalyticsService;
import kg.akoikelov.springmvcapp.services.CashBoxService;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import kg.akoikelov.springmvcapp.utils.ControllerHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class SuperCashBoxController extends BaseController {
    public SuperCashBoxController(
            EmployeeService employeeService,
            AffiliateService affiliateService,
            CashBoxService cashBoxService,
            AnalyticsService analyticsService,
            MailService mailService) {
        super(employeeService, affiliateService, cashBoxService, analyticsService, mailService);
    }

    @GetMapping("/cashboxes")
    public String getCashBoxList(
            @RequestParam(value = "page", defaultValue = "1") String page,
            @RequestParam(value = "pagination", defaultValue = "10") String pagination,
            Model model,
            @RequestParam Map<String, String> allRequest) {
        int pageNumber = ControllerHelper.parseInt(page);
        int paginationNumber = ControllerHelper.parseInt(pagination);
        PaginationData<CashBox> paginationData =
                cashBoxService.getCashBoxList(pageNumber, paginationNumber);
        allRequest.remove("page");
        model.addAttribute("cashbox", paginationData.getData());
        model.addAttribute("query", ControllerHelper.getQueryFromRequest(allRequest));
        model.addAttribute(
                "paginationpages",
                ControllerHelper.pageCount(paginationData.getAllCount(), paginationNumber));

        return "/superadmin/cashboxlist";
    }

    @PostMapping("/cashboxes/{id}/clone")
    public String createCashBoxClone(
            @PathVariable("id") int id, RedirectAttributes redirectAttributes) {

        CashBox cashBox = cashBoxService.getCashBox(id);
        if (cashBox == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        CashBox copy = cashBox.copy();
        boolean ok = cashBoxService.create(copy);
        if (ok) {
            redirectAttributes.addFlashAttribute(
                    "flashSuccess", new String[]{"Копия успешно добавлена"});

        } else {
            redirectAttributes.addFlashAttribute(
                    "flashError", new String[]{"Ошибка при создании копии"});
        }
        return "redirect:/superadmin/cashboxes";
    }

    @GetMapping("/cashboxes/new")
    public String newCashBox(Model model) {
        CashBoxForm cashBoxForm = new CashBoxForm();
        cashBoxForm.setAffiliates(affiliateService.getAffiliatesForSelect());
        model.addAttribute("cashbox", cashBoxForm);
        return "/superadmin/cashbox/new";
    }

    @PostMapping("/cashboxes/new")
    public String createCashBox(
            @Valid @ModelAttribute("cashbox") CashBoxForm cashBoxForm,
            BindingResult result,
            RedirectAttributes redirectAttributes) {
        cashBoxForm.setAffiliates(affiliateService.getAffiliatesForSelect());
        if (result.hasErrors()) {
            return "/superadmin/cashbox/new";
        }
        CashBox cashBox = cashBoxForm.build();
        boolean ok = cashBoxService.create(cashBox);
        if (ok) {
            redirectAttributes.addFlashAttribute(
                    "flashSuccess", new String[]{"Касса успешно добавлена"});
            return "redirect:/superadmin/cashboxes";
        }
        return "/superadmin/cashboxlist";
    }

    @GetMapping("/cashboxes/{id}/edit")
    public String editCashbox(@PathVariable("id") int id, Model model) {
        CashBox cashBox = cashBoxService.getCashBox(id);
        if (cashBox == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        CashBoxForm cashBoxForm = new CashBoxForm(cashBox);
        cashBoxForm.setAffiliates(affiliateService.getAffiliatesForSelect());
        model.addAttribute("cashbox", cashBoxForm);
        model.addAttribute("cashboxid", id);

        return "/superadmin/cashbox/edit";
    }

    @PostMapping("/cashboxes/{id}/edit")
    public String updateCashBox(
            @Valid @ModelAttribute("cashbox") CashBoxForm cashBoxForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model,
            @PathVariable("id") int id) {
        cashBoxForm.setAffiliates(affiliateService.getAffiliatesForSelect());
        model.addAttribute("cashbox", cashBoxForm);
        model.addAttribute("cashboxid", id);
        if (bindingResult.hasErrors()) {
            return "/superadmin/cashbox/edit";
        }
        CashBox cashBox = cashBoxForm.build();
        cashBox.setId(id);
        boolean ok = cashBoxService.updateCashBox(cashBox);
        if (ok) {
            redirectAttributes.addFlashAttribute(
                    "flashSuccess", new String[]{"Касса успешно обновлена"});
            return "redirect:/superadmin/cashboxes";
        }
        return "/superadmin/cashbox/edit";
    }
}
