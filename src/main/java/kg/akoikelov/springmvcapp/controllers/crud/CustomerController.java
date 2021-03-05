package kg.akoikelov.springmvcapp.controllers.crud;

import kg.akoikelov.springmvcapp.forms.CustomerForm;
import kg.akoikelov.springmvcapp.models.Customer;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.services.CustomerService;
import kg.akoikelov.springmvcapp.utils.ControllerHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import kg.akoikelov.springmvcapp.utils.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("customer")
public class CustomerController {
  CustomerService customerService;
  SessionHelper sessionHelper;

  @Autowired
  public CustomerController(CustomerService customerService, SessionHelper sessionHelper) {
    this.customerService = customerService;
    this.sessionHelper = sessionHelper;
  }

  @GetMapping("/list")
  public String getList(
      Model model,
      @RequestParam(value = "page", defaultValue = "1") String page,
      @RequestParam(value = "pagination", defaultValue = "10") String pagination,
      @RequestParam Map<String, String> allRequest) {
    int pageNumber = ControllerHelper.parseInt(page);
    int paginationNumber = ControllerHelper.parseInt(pagination);
    allRequest.remove("page");
    PaginationData<Customer> customers = customerService.getList(pageNumber, paginationNumber);
    model.addAttribute("customers", customers.getData());
    model.addAttribute(
        "paginationpages", ControllerHelper.pageCount(customers.getAllCount(), paginationNumber));
    model.addAttribute("query", ControllerHelper.getQueryFromRequest(allRequest));

    return "/customer/customerslist";
  }

  @GetMapping("/new")
  public String newCustomer(Model model) {
    CustomerForm customerForm = new CustomerForm();
    model.addAttribute("customer", customerForm);

    System.out.println(sessionHelper.getCurrentUser());

    return "/customer/new";
  }

  @PostMapping("/new")
  public String createCustomer(
      @Valid @ModelAttribute("customer") CustomerForm customerForm,
      BindingResult result,
      RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      return "/customer/new";
    }
    Employee employee = sessionHelper.getCurrentUser();
    Customer customer = customerForm.build(employee);
    boolean ok = customerService.create(customer);
    if (ok) {
      redirectAttributes.addFlashAttribute(
          "flashSuccess", new String[] {"Клиент успешно добавлен"});
      return "redirect:/customer/list";
    }

    return "/customer/new";
  }
}
