package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeListMapper implements RowMapper<Employee> {
  public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
    Employee employee = new Employee(resultSet.getInt("id"));

    employee.setUserName(resultSet.getString("username"));
    employee.setFullName(resultSet.getString("full_name"));
    employee.setSalary(resultSet.getInt("salary"));
    employee.setBirthday(resultSet.getDate("birthday"));
    employee.setPhone(resultSet.getString("phone"));

    return employee;
  }
}
