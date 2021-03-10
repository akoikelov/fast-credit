package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Deposit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepositMapper implements RowMapper<Deposit> {
    @Override
    public Deposit mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
