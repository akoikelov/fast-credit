package kg.akoikelov.springmvcapp.controllers.create;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

  @GetMapping("/new")
  public String addNewClient() {

    return "customers/new";
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
