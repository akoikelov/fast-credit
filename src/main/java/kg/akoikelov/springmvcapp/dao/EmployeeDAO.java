package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.models.Employee;

public interface EmployeeDAO {

    Employee findById(Integer id);

    Employee findOneByUsernameAndPassword(String username, String password);

    boolean create(Employee employee);

    boolean update(Employee employee);

    boolean delete(int id);

}
