package kg.akoikelov.springmvcapp.services;

import kg.akoikelov.springmvcapp.dao.EmployeeDAO;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
  EmployeeDAO employeeDAO;

  private final PasswordEncoder passwordEncoder;

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
  public Employee getEmployee(int id){

    Employee employee = employeeDAO.findById(id);
    if (employee!=null){
      employee.setRole(employeeDAO.findRoleForUserName(employee.getUserName()));

    }
    return employee ;
  }
  public boolean updateEmployee(Employee employee){
    return employeeDAO.update(employee);
  }

}
