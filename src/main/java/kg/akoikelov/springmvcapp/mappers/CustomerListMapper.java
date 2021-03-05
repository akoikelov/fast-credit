package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerListMapper implements RowMapper<Customer> {

  @Override
  public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
    Customer customer = new Customer();
    customer.setId(resultSet.getInt("id"));
    customer.setFullName(resultSet.getString("full_name"));
    customer.setBirthday(resultSet.getDate("birthday"));
    customer.setPassportId(resultSet.getString("passport_id"));
    customer.setAddress(resultSet.getString("address"));
    customer.setPhone(resultSet.getString("phone"));
    customer.setSmsPhone(resultSet.getString("sms_phone"));
    customer.setFineEnabled(resultSet.getBoolean("fine_enabled"));
    customer.setBlackList(resultSet.getBoolean("black_list"));

    return customer;
  }
}
