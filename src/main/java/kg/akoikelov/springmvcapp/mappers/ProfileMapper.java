package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileMapper implements RowMapper<Employee> {
  @Override
  public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
    Employee employee = new Employee(resultSet.getInt("id"));
    employee.setUserName(resultSet.getString("username"));
    employee.setPassword(resultSet.getString("password"));
    employee.setFullName(resultSet.getString("full_name"));
    employee.setBirthday(resultSet.getDate("birthday"));
    employee.setComment(resultSet.getString("comment"));
    employee.setAddress(resultSet.getString("address"));
    employee.setPhone(resultSet.getString("phone"));
    return employee;
  }
}
