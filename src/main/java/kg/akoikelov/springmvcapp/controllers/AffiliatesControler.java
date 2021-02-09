package kg.akoikelov.springmvcapp.controllers;

import kg.akoikelov.springmvcapp.models.Affiliate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/affiliates")
public class AffiliatesControler {
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView createNewAffiliates() {

        return new ModelAndView("/affiliates/new", "affiliates", new Affiliate());
    }

    @RequestMapping(value = "/created", method = RequestMethod.POST)
    public String created(@ModelAttribute("affiliates") Affiliate affiliate,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/affiliates/new";
        }

        model.addAttribute("title", affiliate.getTitle());
        model.addAttribute("maxSumMonth", affiliate.getMaxSumMonth());
        model.addAttribute("maxSumDay", affiliate.getMaxSumDay());
        model.addAttribute("maxDays", affiliate.getMaxDays());
        model.addAttribute("maxMonths", affiliate.getMaxMonths());
        model.addAttribute("minPercentage", affiliate.getMinPercentage());
        model.addAttribute("comment", affiliate.getComment());
        model.addAttribute("phone", affiliate.getPhone());
        model.addAttribute("address", affiliate.getAddress());
        model.addAttribute("prefix", affiliate.getPrefix());

        return "/affiliates/created";
    }
}
