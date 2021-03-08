package kg.akoikelov.springmvcapp.utils;

import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionHelper {

  private Employee currentUser;

  private final EmployeeService employeeService;

  @Autowired
  public SessionHelper(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  public Employee getCurrentUser() {
    if (currentUser == null) {
      String username = ControllerHelper.getCurrentUser().getUsername();

      currentUser = employeeService.getUserByUserName(username);
    }

    return currentUser;
  }
}
