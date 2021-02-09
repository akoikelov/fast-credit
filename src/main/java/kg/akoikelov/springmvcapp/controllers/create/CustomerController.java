package kg.akoikelov.springmvcapp.controllers.create;

import kg.akoikelov.springmvcapp.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public ModelAndView addNewClient() {


        return new ModelAndView("customers/new", "customer", new Customer());
    }


    @GetMapping("/newdepositauto")
    public String addNewDepositAuto() {
        return "customers/newdepositauto";
    }

    @GetMapping("/newdepositanother")
    public String addNewDepositAnother() {
        return "customers/newdepositanother";
    }

    @GetMapping("/newcontract")
    public String addNewContract() {
        return "customers/newcontract";
    }

    @GetMapping("/newpayment")
    public String addNewPayment() {
        return "customers/newpayment";
    }


}
