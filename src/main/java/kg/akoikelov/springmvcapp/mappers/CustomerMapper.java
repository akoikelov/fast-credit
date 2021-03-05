package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
  @Override
  public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
    return null;
  }
}
