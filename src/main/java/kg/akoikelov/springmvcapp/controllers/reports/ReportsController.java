package kg.akoikelov.springmvcapp.controllers.reports;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class ReportsController {
    @GetMapping("/clientsreports")
    public String getClientsReports() {
        return "/reports/getclientreport";
    }

    @GetMapping("/cashboxreports")
    public String getCashboxReports() {
        return "/reports/cashboxreport";
    }

    @GetMapping("/debtorreports")
    public String getDeborReports() {
        return "/reports/deborreport";
    }

    @GetMapping("/nondebtorreports")
    public String getNonDeborReports() {
        return "/reports/nondebtorreport";
    }

    @GetMapping("/costreports")
    public String getCostReports() {
        return "/reports/costreport";
    }

    @GetMapping("/creditreports")
    public String getCredittReports() {
        return "/reports/creditreport";
    }
}
