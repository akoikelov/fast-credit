package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Affiliate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AffiliatesListMapper implements RowMapper<Affiliate> {
  @Override
  public Affiliate mapRow(ResultSet resultSet, int i) throws SQLException {
    Affiliate affiliate = new Affiliate(resultSet.getInt("id"));
    affiliate.setTitle(resultSet.getString("title"));
    affiliate.setMaxSumMonth(resultSet.getInt("max_sum_month"));
    affiliate.setMaxSumDay(resultSet.getInt("max_sum_day"));

    return affiliate;
  }
}
