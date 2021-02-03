package kg.akoikelov.springmvcapp.controllers.cashbox;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cashbox")
public class CashBoxController {
    @GetMapping("/newpko")
    public String addNewPKO() {
        return "cashbox/newpko";
    }

    @GetMapping("/newrko")
    public String addNewRKO() {
        return "cashbox/newrko";
    }

    @GetMapping("/newrkopartner")
    public String addNewRKOPartner() {
        return "cashbox/newrkopartner";
    }
}
