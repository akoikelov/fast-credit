package kg.akoikelov.springmvcapp.controllers;

import kg.akoikelov.springmvcapp.dao.AffiliatesDAO;
import kg.akoikelov.springmvcapp.models.Affiliate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final AffiliatesDAO affiliatesDAO;

    @Autowired
    public IndexController(AffiliatesDAO affiliatesDAO) {
        this.affiliatesDAO = affiliatesDAO;
    }

    @GetMapping
    public String index(Model model) {
//        Affiliate affiliate = new Affiliate();
//        affiliate.setTitle("vasy");
//        affiliate.setMaxSumMonth(11);
//        affiliate.setMaxSumDay(123);
//        affiliate.setMaxDays(12);
//        affiliate.setMaxMonths(34);
//        affiliate.setMinPercentage(12.4f);
//        affiliate.setPrefix("Art");
//        affiliatesDAO.create(affiliate);

        return "index";
    }

}
