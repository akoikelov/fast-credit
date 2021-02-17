package kg.akoikelov.springmvcapp.controllers.superadmin;

import kg.akoikelov.springmvcapp.forms.AffiliateForm;
import kg.akoikelov.springmvcapp.forms.EmployeeForm;
import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.services.AffiliateService;
import kg.akoikelov.springmvcapp.services.CashBoxService;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import kg.akoikelov.springmvcapp.utils.ControllerHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/superadmin")
public class SuperAdminController {
  EmployeeService employeeService;
  AffiliateService affiliateService;
  CashBoxService cashBoxService;

  @Autowired
  public SuperAdminController(
      EmployeeService employeeService,
      AffiliateService affiliateService,
      CashBoxService cashBoxService) {
    this.employeeService = employeeService;
    this.affiliateService = affiliateService;
    this.cashBoxService = cashBoxService;
  }

  @GetMapping("/employees/new")
  public String createNewEmployee(Model model) {
    EmployeeForm employeeForm = new EmployeeForm();
    employeeForm.setAffiliates(affiliateService.getAffiliatesForSelect());
    employeeForm.setCashboxes(cashBoxService.getAllForSelect());

    model.addAttribute("employee", employeeForm);
    return "/superadmin/employee/new";
  }

  @PostMapping("/employees/new")
  public String createNewEmployees(
      @Valid @ModelAttribute("employee") EmployeeForm employeeForm,
      BindingResult bindingResult,
      RedirectAttributes redirectAttributes) {

    employeeForm.setAffiliates(affiliateService.getAffiliatesForSelect());
    employeeForm.setCashboxes(cashBoxService.getAllForSelect());

    if (bindingResult.hasErrors()) {
      return "/superadmin/employee/new";
    }

    Employee employee = employeeForm.build();
    boolean ok = employeeService.createEmployee(employee);
    if (ok) {
      redirectAttributes.addFlashAttribute(
          "flashSuccess", new String[] {"Сотрудник успешно добавлен"});
      return "redirect:/superadmin/employees";
    }
    return "/superadmin/employee/new";
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

  @GetMapping("/affiliates/{id}/edit")
  public String editAffiliate(Model model, @PathVariable(value = "id") Integer id) {
    Affiliate affiliate = affiliateService.getAffiliate(id);

    if (affiliate == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
    }

    model.addAttribute("form", new AffiliateForm(affiliate));
    model.addAttribute("affiliateId", id);

    return "/superadmin/affiliates/edit";
  }

  @PostMapping("/affiliates/{id}/edit")
  public String updateAffiliate(
      @PathVariable(value = "id") Integer id,
      @Valid @ModelAttribute("form") AffiliateForm affiliateForm,
      BindingResult result,
      RedirectAttributes redirectAttributes,
      Model model) {

    model.addAttribute("affiliateId", id);

    if (result.hasErrors()) { // Если есть ошибки в данных, заново вывожу шаблон
      return "/superadmin/affiliates/edit";
    }

    Affiliate affiliate = affiliateForm.build();
    affiliate.setId(id);

    boolean ok = affiliateService.updateAffiliate(affiliate);

    if (ok) {
      redirectAttributes.addFlashAttribute(
          "flashSuccess", new String[] {"Филиал успешно обновлен"});

      return "redirect:/superadmin/affiliates";
    }

    return "/superadmin/affiliates/edit";
  }
}
