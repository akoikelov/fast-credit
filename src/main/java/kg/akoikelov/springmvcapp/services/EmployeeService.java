package kg.akoikelov.springmvcapp.services;

import kg.akoikelov.springmvcapp.utils.PaginationData;
import kg.akoikelov.springmvcapp.dao.EmployeeDAO;
import kg.akoikelov.springmvcapp.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
  EmployeeDAO employeeDAO;

  @Autowired
  public EmployeeService(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public PaginationData<Employee> getEmployees(int page, int limit) {
    return employeeDAO.findForList(page, limit);
  }
}
