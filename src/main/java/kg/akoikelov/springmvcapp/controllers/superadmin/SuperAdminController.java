package kg.akoikelov.springmvcapp.controllers.superadmin;

import kg.akoikelov.springmvcapp.forms.*;
import kg.akoikelov.springmvcapp.mail.MailService;
import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.models.Analytics;
import kg.akoikelov.springmvcapp.models.CashBox;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.services.AffiliateService;
import kg.akoikelov.springmvcapp.services.AnalyticsService;
import kg.akoikelov.springmvcapp.services.CashBoxService;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import kg.akoikelov.springmvcapp.utils.ControllerHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/superadmin")
public class SuperAdminController {
  EmployeeService employeeService;
  AffiliateService affiliateService;
  CashBoxService cashBoxService;
  AnalyticsService analyticsService;
  MailService mailService;

  Logger logger = LoggerFactory.getLogger(SuperAdminController.class);

  @Autowired
  public SuperAdminController(
      EmployeeService employeeService,
      AffiliateService affiliateService,
      CashBoxService cashBoxService,
      AnalyticsService analyticsService,
      MailService mailService) {
    this.employeeService = employeeService;
    this.affiliateService = affiliateService;
    this.cashBoxService = cashBoxService;
    this.analyticsService = analyticsService;
    this.mailService = mailService;
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

  @GetMapping("employees/{id}/edit")
  public String editEmployee(
      @PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
    Employee employee = employeeService.getEmployee(id);

    if (employee == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    User currentUser = ControllerHelper.getCurrentUser();
    if (currentUser.getUsername().equals(employee.getUserName())) {
      redirectAttributes.addFlashAttribute(
          "flashError", new String[] {"Нельзя изменять самого себя"});
      return "redirect:/superadmin/employees";
    }

    EmployeeEditForm employeeEditForm = new EmployeeEditForm(employee);
    employeeEditForm.setAffiliates(affiliateService.getAffiliatesForSelect());
    employeeEditForm.setCashboxes(cashBoxService.getAllForSelect());
    model.addAttribute("employee", employeeEditForm);
    model.addAttribute("employeeId", id);
    return "superadmin/employee/edit";
  }

  @PostMapping("/employees/{id}/edit")
  public String updateEmployee(
      @Valid @ModelAttribute("employee") EmployeeEditForm employeeEditForm,
      BindingResult bindingResult,
      @PathVariable("id") Integer id,
      RedirectAttributes redirectAttributes,
      Model model) {
    employeeEditForm.setCashboxes(cashBoxService.getAllForSelect());
    employeeEditForm.setAffiliates(affiliateService.getAffiliatesForSelect());

    model.addAttribute("employee", employeeEditForm);
    model.addAttribute("employeeId", id);
    if (bindingResult.hasErrors()) {
      return "superadmin/employee/edit";
    }
    Employee employee = employeeEditForm.build();
    employee.setId(id);
    boolean ok = employeeService.updateEmployee(employee);

    if (ok) {
      if (employeeEditForm.roleChanged()) {
        mailService.sendSimpleMessage("Изменение роли", "Ваша роль изменена");
      }
      redirectAttributes.addFlashAttribute(
          "flashSuccess", new String[] {"Сотрудник успешно обновлен"});
      return "redirect:/superadmin/employees";
    }
    return "superadmin/employee/edit";
  }

  @GetMapping("/employees")
  public String getEmployeeList(
      @RequestParam(value = "page", defaultValue = "1") String page,
      @RequestParam(value = "pagination", defaultValue = "10") String pagination,
      Model model,
      @RequestParam Map<String, String> allRequestParams) {
    int paginationNumber = ControllerHelper.parseInt(pagination);
    int pageNumber = ControllerHelper.parseInt(page);
    PaginationData<Employee> paginationData =
        employeeService.getEmployees(pageNumber, paginationNumber);

    allRequestParams.remove("page");
    String query = ControllerHelper.getQueryFromRequest(allRequestParams);

    model.addAttribute("employees", paginationData.getData());
    model.addAttribute(
        "paginationpages",
        ControllerHelper.pageCount(paginationData.getAllCount(), paginationNumber));
    model.addAttribute("query", query);

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

  /*
  Касса
   */

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
          "flashSuccess", new String[] {"Копия успешно добавлена"});

    } else {
      redirectAttributes.addFlashAttribute(
          "flashError", new String[] {"Ошибка при создании копии"});
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
          "flashSuccess", new String[] {"Касса успешно добавлена"});
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
          "flashSuccess", new String[] {"Касса успешно обновлена"});
      return "redirect:/superadmin/cashboxes";
    }
    return "/superadmin/cashbox/edit";
  }

  /*
  Аналитика
   */

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

  /*
  Филилалы
   */

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
