package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Affiliate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AffiliatesMapper implements RowMapper<Affiliate> {
  @Override
  public Affiliate mapRow(ResultSet resultSet, int i) throws SQLException {
    Affiliate affiliate = new Affiliate(resultSet.getInt("id"));
    affiliate.setTitle(resultSet.getString("title"));
    affiliate.setMaxSumMonth(resultSet.getInt("max_sum_month"));
    affiliate.setMaxSumDay(resultSet.getInt("max_sum_day"));
    affiliate.setMaxDays(resultSet.getInt("max_days"));
    affiliate.setMinPercentage(resultSet.getFloat("min_percentage"));
    affiliate.setComment(resultSet.getString("comment"));
    affiliate.setPhone(resultSet.getString("phone"));
    affiliate.setAddress(resultSet.getString("address"));
    affiliate.setPrefix(resultSet.getString("prefix"));
    affiliate.setMaxMonths(resultSet.getInt("max_months"));

    return affiliate;
  }
}
