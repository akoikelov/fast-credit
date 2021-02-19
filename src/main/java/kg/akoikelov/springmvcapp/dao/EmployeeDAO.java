package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.utils.PaginationData;

public interface EmployeeDAO extends FieldValueExists {

  Employee findById(Integer id);

  PaginationData<Employee> findForList(int page, int limit);

  Employee findOneByUsernameAndPassword(String username, String password);

  boolean create(Employee employee);

  boolean update(Employee employee);

  boolean delete(int id);

  String findRoleForUserName(String username);
}
