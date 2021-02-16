package kg.akoikelov.springmvcapp.utils;

import org.springframework.jdbc.core.JdbcTemplate;

public class DaoHelper {

  public static boolean fieldValueExists(
      JdbcTemplate jdbcTemplate, String tableName, String fieldName, Object value) {
    String sql = "select count(*) from " + tableName + " where " + fieldName + " = ?";

    Integer count = jdbcTemplate.queryForObject(sql, new Object[] {value}, Integer.class);

    return count != null && count > 0;
  }
}
