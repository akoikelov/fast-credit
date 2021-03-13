package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Deposit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepositMapper implements RowMapper<Deposit> {
    @Override
    public Deposit mapRow(ResultSet resultSet, int i) throws SQLException {
        Deposit deposit = new Deposit();
        deposit.setId(resultSet.getInt("id"));
        deposit.setTitle(resultSet.getString("title"));
        deposit.setNotes(resultSet.getString("notes"));
        deposit.setComment(resultSet.getString("comment"));
        deposit.setCustomerId(resultSet.getInt("customer_id"));
        return deposit;
    }
}
