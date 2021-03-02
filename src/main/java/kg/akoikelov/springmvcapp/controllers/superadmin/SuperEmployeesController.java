package kg.akoikelov.springmvcapp.controllers.superadmin;

import kg.akoikelov.springmvcapp.forms.EmployeeEditForm;
import kg.akoikelov.springmvcapp.forms.EmployeeForm;
import kg.akoikelov.springmvcapp.mail.MailService;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.services.AffiliateService;
import kg.akoikelov.springmvcapp.services.AnalyticsService;
import kg.akoikelov.springmvcapp.services.CashBoxService;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import kg.akoikelov.springmvcapp.utils.ControllerHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
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
public class SuperEmployeesController extends BaseController {

  public SuperEmployeesController(
      EmployeeService employeeService,
      AffiliateService affiliateService,
      CashBoxService cashBoxService,
      AnalyticsService analyticsService,
      MailService mailService) {
    super(employeeService, affiliateService, cashBoxService, analyticsService, mailService);
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
}
