package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.mappers.CashBoxMapperForSelect;
import kg.akoikelov.springmvcapp.models.CashBox;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CashBoxDAOSql implements CashBoxDAO {
  JdbcTemplate jdbcTemplate;

  public CashBoxDAOSql(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<CashBox> findAllForSelect() {
    String sql = "SElECT id, title from cashboxes";

    return jdbcTemplate.query(sql, new CashBoxMapperForSelect());
  }

  @Override
  public boolean fieldValueExists(String fieldName, Object value, int id) {
    return false;
  }
}
