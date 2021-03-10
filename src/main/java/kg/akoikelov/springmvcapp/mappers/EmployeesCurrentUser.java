package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesCurrentUser implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setUserName(resultSet.getString("username"));
        employee.setAffiliateId(resultSet.getInt("affiliate_id"));
        employee.setCashboxId(resultSet.getInt("cashbox_id"));
        return employee;
    }
}
