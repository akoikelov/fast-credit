package kg.akoikelov.springmvcapp.controllers.superadmin;

import kg.akoikelov.springmvcapp.mail.MailService;
import kg.akoikelov.springmvcapp.services.AffiliateService;
import kg.akoikelov.springmvcapp.services.AnalyticsService;
import kg.akoikelov.springmvcapp.services.CashBoxService;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/superadmin")
public abstract class BaseController {
    protected EmployeeService employeeService;
    protected AffiliateService affiliateService;
    protected CashBoxService cashBoxService;
    protected AnalyticsService analyticsService;
    protected MailService mailService;

    @Autowired
    public BaseController(
            EmployeeService employeeService,
            AffiliateService affiliateService,
            CashBoxService cashBoxService,
            AnalyticsService analyticsService,
            MailService mailService) {
        this.employeeService = employeeService;
        this.affiliateService = affiliateService;
        this.cashBoxService = cashBoxService;
        this.analyticsService = analyticsService;
        this.mailService = mailService;
    }
}
