package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Affiliate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AffiliatesListMapperForSelect implements RowMapper<Affiliate> {
  @Override
  public Affiliate mapRow(ResultSet resultSet, int i) throws SQLException {
    Affiliate affiliate = new Affiliate(resultSet.getInt("id"));
    affiliate.setTitle(resultSet.getString("title"));
    return affiliate;
  }
}
