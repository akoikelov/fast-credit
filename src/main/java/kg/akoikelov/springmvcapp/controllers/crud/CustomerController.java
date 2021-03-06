package kg.akoikelov.springmvcapp.controllers.crud;

import kg.akoikelov.springmvcapp.forms.CustomerForm;
import kg.akoikelov.springmvcapp.models.Customer;
import kg.akoikelov.springmvcapp.models.Deposit;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.services.CustomerService;
import kg.akoikelov.springmvcapp.services.DepositService;
import kg.akoikelov.springmvcapp.utils.ControllerHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import kg.akoikelov.springmvcapp.utils.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("customer")
public class CustomerController {
    CustomerService customerService;
    SessionHelper sessionHelper;
    DepositService depositService;

    @Autowired
    public CustomerController(CustomerService customerService, SessionHelper sessionHelper, DepositService depositService) {
        this.customerService = customerService;
        this.sessionHelper = sessionHelper;
        this.depositService = depositService;
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

        return "/customer/list";
    }

    @GetMapping("/new")
    public String newCustomer(Model model) {
        CustomerForm customerForm = new CustomerForm();
        model.addAttribute("customer", customerForm);

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
        Employee employee = sessionHelper.getCurrentUser(ControllerHelper.getCurrentUser().getUsername());
        Customer customer = customerForm.build(employee);
        boolean ok = customerService.create(customer);
        if (ok) {
            redirectAttributes.addFlashAttribute(
                    "flashSuccess", new String[]{"Клиент успешно добавлен"});
            return "redirect:/customer/list";
        }

        return "/customer/new";
    }

    @GetMapping("/{id}/edit")
    public String editCustomer(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        CustomerForm customerForm = new CustomerForm(customer);
        model.addAttribute("customer", customerForm);
        model.addAttribute("customerId", id);
        return "customer/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateCustomer(@Valid @ModelAttribute("customer") CustomerForm customerForm,
                                 BindingResult result,
                                 RedirectAttributes redirectAttributes, @PathVariable("id") int id, Model model) {
        if (result.hasErrors()) {
            return "customer/edit";
        }
        model.addAttribute("customer", customerForm);
        model.addAttribute("customerId", id);
        Employee employee = sessionHelper.getCurrentUser(ControllerHelper.getCurrentUser().getUsername());
        Customer customer = customerForm.build(employee);
        customer.setId(id);
        boolean ok = customerService.update(customer);
        if (ok) {
            redirectAttributes.addFlashAttribute("flashSuccess", new String[]{"Клиент успешно обновлен"});
            return "redirect:/customer/list";
        }


        return "customer/edit";
    }

    @GetMapping("/{customerId}/details")
    public String detailsPage(@PathVariable("customerId") int id, Model model) {

        Customer customer = customerService.getCustomerById(id);
        List<Deposit> deposit = depositService.findAll(id);
        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        CustomerForm customerForm = new CustomerForm(customer);
        model.addAttribute("customer", customerForm);
        model.addAttribute("customerId", id);
        model.addAttribute("deposit", deposit);
        return "customer/details";
    }

}
