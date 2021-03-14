package kg.akoikelov.springmvcapp.controllers.crud;

import kg.akoikelov.springmvcapp.dao.EmployeeDAO;
import kg.akoikelov.springmvcapp.forms.DepositForm;
import kg.akoikelov.springmvcapp.models.Deposit;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.services.CustomerService;
import kg.akoikelov.springmvcapp.services.DepositService;
import kg.akoikelov.springmvcapp.utils.ControllerHelper;
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

@Controller
@RequestMapping("/customer/{customerId}/deposit")
public class DepositController {
    EmployeeDAO employeeDAO;
    DepositService depositService;
    CustomerService customerService;
    SessionHelper sessionHelper;

    @Autowired
    public DepositController(EmployeeDAO employeeDAO, DepositService depositService, CustomerService customerService, SessionHelper sessionHelper) {
        this.employeeDAO = employeeDAO;
        this.depositService = depositService;
        this.customerService = customerService;
        this.sessionHelper = sessionHelper;

    }

    @GetMapping("/new")
    public String newDeposit(@PathVariable("customerId") int id, Model model) {

        boolean ok = customerService.checkCustomer(id);

        if (ok) {
            model.addAttribute("deposit", new DepositForm());
            model.addAttribute("customerId", id);
            return "deposit/new";
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/new")
    public String createDeposit(@Valid @ModelAttribute("deposit") DepositForm depositForm,
                                BindingResult result, RedirectAttributes redirectAttributes, Model model,
                                @PathVariable("customerId") int id) {
        if (result.hasErrors()) {
            return "deposit/new";
        }

        model.addAttribute("deposit", depositForm);
        model.addAttribute("customerId", id);
        Employee employee = sessionHelper.getCurrentUser(ControllerHelper.getCurrentUser().getUsername());
        Deposit deposit = depositForm.build(employee);
        deposit.setCustomerId(id);
        boolean ok = depositService.create(deposit);
        if (ok) {
            redirectAttributes.addFlashAttribute("flashSuccess", new String[]{"Депозит успешно добавлен"});
            return "redirect:/customer/" + id + "/details";
        }


        return "deposit/new";
    }

    @GetMapping("/{depositId}/edit")
    public String editDeposit(@PathVariable("customerId") int id, @PathVariable("depositId") int depId, Model model) {
        Deposit deposit = depositService.getDepositById(depId);
        if (deposit == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        DepositForm depositForm = new DepositForm(deposit);
        model.addAttribute("deposit", depositForm);
        model.addAttribute("customerId", id);
        return "deposit/edit";
    }

    @PostMapping("/{depositId}/edit")
    public String updateDeposit(@Valid @ModelAttribute("deposit") DepositForm depositForm,
                                BindingResult result,
                                RedirectAttributes redirectAttributes, @PathVariable("depositId") int depId,
                                @PathVariable("customerId") int id) {
        if (result.hasErrors()) {
            return "deposit/edit";
        }
        Employee employee = sessionHelper.getCurrentUser(ControllerHelper.getCurrentUser().getUsername());
        Deposit deposit = depositForm.build(employee);
        deposit.setId(depId);
        boolean ok = depositService.update(deposit);
        if (ok) {
            redirectAttributes.addFlashAttribute("flashSuccess", new String[]{"Залог успешно обновлен"});
            return "redirect:/customer/" + id + "/details";
        }
        return "deposit/edit";
    }

}
