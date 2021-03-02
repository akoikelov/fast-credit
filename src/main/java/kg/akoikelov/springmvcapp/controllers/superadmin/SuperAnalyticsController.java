package kg.akoikelov.springmvcapp.controllers.superadmin;

import kg.akoikelov.springmvcapp.forms.AnalyticsForm;
import kg.akoikelov.springmvcapp.mail.MailService;
import kg.akoikelov.springmvcapp.models.Analytics;
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
public class SuperAnalyticsController extends BaseController {
  public SuperAnalyticsController(
      EmployeeService employeeService,
      AffiliateService affiliateService,
      CashBoxService cashBoxService,
      AnalyticsService analyticsService,
      MailService mailService) {
    super(employeeService, affiliateService, cashBoxService, analyticsService, mailService);
  }

  @GetMapping("/analytics")
  public String getAnalyticsList(
      @RequestParam(value = "page", defaultValue = "1") String page,
      @RequestParam(value = "pagination", defaultValue = "10") String pagination,
      @RequestParam Map<String, String> allRequest,
      Model model) {
    int pageNumber = ControllerHelper.parseInt(page);
    int paginationNumber = ControllerHelper.parseInt(pagination);
    allRequest.remove("page");
    PaginationData<Analytics> paginationData =
        analyticsService.getAnalyticsList(pageNumber, paginationNumber);
    model.addAttribute("analytics", paginationData.getData());
    model.addAttribute("query", ControllerHelper.getQueryFromRequest(allRequest));
    model.addAttribute(
        "paginationpages",
        ControllerHelper.pageCount(paginationData.getAllCount(), paginationNumber));

    return "/superadmin/analyticslist";
  }

  @GetMapping("/analytics/new")
  public String newAnalytics(Model model) {
    model.addAttribute("analytics", new AnalyticsForm());

    return "/superadmin/analytics/new";
  }

  @PostMapping("/analytics/new")
  public String createAnalytics(
      @Valid @ModelAttribute("analytics") AnalyticsForm analyticsForm,
      BindingResult bindingResult,
      RedirectAttributes redirectAttributes,
      Model model) {
    if (bindingResult.hasErrors()) {
      return "/superadmin/analytics/new";
    }
    Analytics analytics = analyticsForm.build();
    boolean ok = analyticsService.create(analytics);
    if (ok) {
      redirectAttributes.addFlashAttribute(
          "flashSuccess", new String[] {"Аналитика успешно добавлена"});
      return "redirect:/superadmin/analytics";
    }
    return "/superadmin/analytics/new";
  }

  @GetMapping("/analytics/{id}/edit")
  public String editAnalytics(@PathVariable("id") int id, Model model) {
    Analytics analytics = analyticsService.getById(id);
    if (analytics == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    model.addAttribute("analytics", new AnalyticsForm(analytics));
    model.addAttribute("analyticsId", id);

    return "/superadmin/analytics/edit";
  }

  @PostMapping("/analytics/{id}/edit")
  public String updateAnalytics(
      @Valid @ModelAttribute("analytics") AnalyticsForm analyticsForm,
      BindingResult bindingResult,
      RedirectAttributes redirectAttributes,
      Model model,
      @PathVariable("id") int id) {
    model.addAttribute("analytics", analyticsForm);
    model.addAttribute("analyticsId", id);
    if (bindingResult.hasErrors()) {
      return "/superadmin/analytics/edit";
    }

    Analytics analytics = analyticsForm.build();
    analytics.setId(id);
    boolean ok = analyticsService.update(analytics);
    if (ok) {
      redirectAttributes.addFlashAttribute(
          "flashSuccess", new String[] {"Аналитика успешно обновлена"});
      return "redirect:/superadmin/analytics";
    }
    return "/superadmin/analytics/edit";
  }
}
