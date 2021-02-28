package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Analytics;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnalyticsMapper implements RowMapper<Analytics> {
  @Override
  public Analytics mapRow(ResultSet resultSet, int i) throws SQLException {
    return null;
  }
}
