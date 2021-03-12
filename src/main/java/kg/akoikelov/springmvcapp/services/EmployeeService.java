package kg.akoikelov.springmvcapp.services;

import kg.akoikelov.springmvcapp.dao.EmployeeDAO;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
  private final PasswordEncoder passwordEncoder;
  EmployeeDAO employeeDAO;

  @Autowired
  public EmployeeService(EmployeeDAO employeeDAO, PasswordEncoder passwordEncoder) {
    this.employeeDAO = employeeDAO;
    this.passwordEncoder = passwordEncoder;
  }

  public PaginationData<Employee> getEmployees(int page, int limit) {
    return employeeDAO.findForList(page, limit);
  }

  public boolean createEmployee(Employee employee) {
    employee.setPassword(passwordEncoder.encode(employee.getPassword()));
    return employeeDAO.create(employee);
  }

  public Employee getEmployee(int id) {

    Employee employee = employeeDAO.findById(id);
    if (employee != null) {
      employee.setRole(employeeDAO.findRoleForUserName(employee.getUserName()));
    }
    return employee;
  }

  public boolean updateEmployee(Employee employee) {
    return employeeDAO.update(employee);
  }

  public Employee getEmployeeByUsername(String username) {
    return employeeDAO.findByUserName(username);
  }

  public boolean updateProfile(Employee employee) {
    employee.setPassword(passwordEncoder.encode(employee.getPassword()));
    return employeeDAO.updateProfile(employee);
  }

  public Employee getUserByUserName(String userName) {
    return employeeDAO.findByUser(userName);
  }

  public Employee getUserByUserNameForJwt(String userName) {
    return employeeDAO.findByUsernameForJwt(userName);
  }

  public Employee getUserByUserNameAndPassword(String userName, String password) {
    Employee employee = employeeDAO.findByUserName(userName);

    if (employee == null) {
      return null;
    }

    if (passwordEncoder.matches(password, employee.getPassword())) {
      return employee;
    }

    return null;
  }
}
