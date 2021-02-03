package kg.akoikelov.springmvcapp.controllers.superadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/superadmin")
public class SuperAdminController {

    @GetMapping("/branches")
    public String getBranchList() {
        return "/superadmin/branchlist";
    }

    @GetMapping("/employees")
    public String getEmployeeList() {
        return "/superadmin/employeelist";
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
