package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.CashBox;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CashBoxMapper implements RowMapper<CashBox> {
  @Override
  public CashBox mapRow(ResultSet resultSet, int i) throws SQLException {
    CashBox cashBox = new CashBox();
    cashBox.setId(resultSet.getInt("id"));
    cashBox.setTitle(resultSet.getString("title"));
    cashBox.setAffiliateId(resultSet.getInt("affiliate_id"));
    cashBox.setComment(resultSet.getString("comment"));
    return cashBox;
  }
}
