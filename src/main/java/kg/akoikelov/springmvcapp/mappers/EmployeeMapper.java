package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee(resultSet.getInt("id"));

        employee.setUserName(resultSet.getString("username"));
        employee.setPassword(resultSet.getString("password"));
        employee.setFullName(resultSet.getString("full_name"));
        employee.setPosition(resultSet.getString("position"));
        employee.setSalary(resultSet.getInt("salary"));
        employee.setWorking(resultSet.getBoolean("is_working"));
        employee.setBirthday(resultSet.getDate("birthday"));
        employee.setPassportId(resultSet.getString("passport_id"));
        employee.setAffiliateId(resultSet.getInt("affiliate_id"));
        employee.setCashboxId(resultSet.getInt("cashbox_id"));
        employee.setComment(resultSet.getString("comment"));
        employee.setRole(resultSet.getString("role"));
        employee.setAddress(resultSet.getString("address"));
        employee.setPhone(resultSet.getString("phone"));

        return employee;
    }
}
