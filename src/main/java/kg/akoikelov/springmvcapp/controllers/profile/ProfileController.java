package kg.akoikelov.springmvcapp.controllers.profile;

import kg.akoikelov.springmvcapp.controllers.superadmin.SuperAdminController;
import kg.akoikelov.springmvcapp.forms.ProfileForm;
import kg.akoikelov.springmvcapp.mail.MailService;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.services.AffiliateService;
import kg.akoikelov.springmvcapp.services.CashBoxService;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import kg.akoikelov.springmvcapp.utils.ControllerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProfileController {

  EmployeeService employeeService;
  AffiliateService affiliateService;
  CashBoxService cashBoxService;
  MailService mailService;

  @Autowired
  public ProfileController(
      EmployeeService employeeService,
      AffiliateService affiliateService,
      CashBoxService cashBoxService,
      MailService mailService) {
    this.employeeService = employeeService;
    this.affiliateService = affiliateService;
    this.cashBoxService = cashBoxService;
    this.mailService = mailService;
  }



  @GetMapping("/profile")
  public String getProfilePage(Model model) {
    User currentUser = ControllerHelper.getCurrentUser();
    String userName = currentUser.getUsername();
    Employee employee = employeeService.getEmployeeByUsername(userName);
    if (employee == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    ProfileForm profileForm = new ProfileForm(employee);
    model.addAttribute("profile", profileForm);
    return "/profile/index";
  }

  @PostMapping("/profile")
  public String updateProfile(
      @Valid @ModelAttribute("profile") ProfileForm profileForm,
      BindingResult bindingResult,
      RedirectAttributes redirectAttributes,
      Model model) {

    if (bindingResult.hasErrors()) {
      return "/profile/index";
    }
    Employee employee = profileForm.buildProfile();
    boolean ok = employeeService.updateProfile(employee);
    if (ok) {
      redirectAttributes.addFlashAttribute("flashSuccess", new String[] {"Вы успешно обновлены"});
      return "redirect:/profile";
    }
    return "/profile/index";
  }
}
