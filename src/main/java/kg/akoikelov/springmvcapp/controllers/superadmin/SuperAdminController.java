package kg.akoikelov.springmvcapp.controllers.superadmin;

import kg.akoikelov.springmvcapp.forms.AffiliateForm;
import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.services.AffiliateService;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import kg.akoikelov.springmvcapp.utils.ControllerHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/superadmin")
public class SuperAdminController {
  EmployeeService employeeService;
  AffiliateService affiliateService;

  @Autowired
  public SuperAdminController(EmployeeService employeeService, AffiliateService affiliateService) {
    this.employeeService = employeeService;
    this.affiliateService = affiliateService;
  }

  @GetMapping("/employees")
  public String getEmployeeList(
      @RequestParam(value = "page", defaultValue = "1") String page,
      @RequestParam(value = "pagination", defaultValue = "10") String pagination,
      Model model) {
    int paginationNumber = ControllerHelper.parseInt(pagination);
    int pageNumber = ControllerHelper.parseInt(page);
    PaginationData<Employee> paginationData =
        employeeService.getEmployees(pageNumber, paginationNumber);

    model.addAttribute("employees", paginationData.getData());
    model.addAttribute(
        "paginationpages",
        ControllerHelper.pageCount(paginationData.getAllCount(), paginationNumber));
    return "/superadmin/employeelist";
  }

  @GetMapping("/affiliates")
  public String getAffiliateList(
      @RequestParam(value = "page", defaultValue = "1") String page,
      @RequestParam(value = "pagination", defaultValue = "10") String pagination,
      Model model) {

    int paginationNumber = ControllerHelper.parseInt(pagination);
    int pageNumber = ControllerHelper.parseInt(page);
    PaginationData<Affiliate> paginationData =
        affiliateService.getAffiliates(pageNumber, paginationNumber);

    model.addAttribute("affiliates", paginationData.getData());
    model.addAttribute(
        "paginationpages",
        ControllerHelper.pageCount(paginationData.getAllCount(), paginationNumber));

    return "/superadmin/affiliatelist";
  }

  @GetMapping("/cashboxes")
  public String getCashBoxList() {
    return "/superadmin/cashboxlist";
  }

  @GetMapping("/analytics")
  public String getAnalyticsList() {
    return "/superadmin/analyticslist";
  }

  @GetMapping("/affiliates/new")
  public String newAffiliate(Model model) {
    model.addAttribute("form", new AffiliateForm());

    return "/superadmin/affiliates/new";
  }

  @PostMapping("/affiliates/new")
  public String createAffiliate(
      @Valid @ModelAttribute("form") AffiliateForm affiliateForm,
      BindingResult result,
      RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) { // Если есть ошибки в данных, заново вывожу шаблон
      return "/superadmin/affiliates/new";
    }

    Affiliate affiliate = affiliateForm.build();
    boolean ok = affiliateService.saveAffiliate(affiliate);

    if (ok) {
      redirectAttributes.addFlashAttribute(
          "flashSuccess", new String[] {"Филиал успешно добавлен"});

      return "redirect:/superadmin/affiliates";
    }

    return "/superadmin/affiliates/new";
  }
}
