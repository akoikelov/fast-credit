package kg.akoikelov.springmvcapp.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

  @GetMapping("/cancelinterest")
  public String cancelInterest() {
    return "/admin/cancelinterest";
  }

  @GetMapping("/payroll")
  public String payRoll() {
    return "/admin/payroll";
  }

  @GetMapping("/transfer")
  public String moneyTransfer() {
    return "/admin/transfer";
  }

  @GetMapping("/transferofaccrual")
  public String transferOfAccrual() {
    return "/admin/transferofaccrual";
  }

  @GetMapping("/missedcharges")
  public String missedCharges() {
    return "/admin/missedCharges";
  }
}
