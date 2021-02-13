package kg.akoikelov.springmvcapp.controllers.superadmin;

import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.services.AffiliateService;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import kg.akoikelov.springmvcapp.utils.ControllerHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
