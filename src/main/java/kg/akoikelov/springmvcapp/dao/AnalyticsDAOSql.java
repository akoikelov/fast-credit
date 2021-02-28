package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.mappers.AnalyticsListMapper;
import kg.akoikelov.springmvcapp.models.Analytics;
import kg.akoikelov.springmvcapp.utils.DaoHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnalyticsDAOSql implements AnalyticsDAO {
  JdbcTemplate jdbcTemplate;

  @Autowired
  public AnalyticsDAOSql(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public PaginationData<Analytics> getAnalyticsList(int page, int limit) {
    int offset = (page - 1) * limit;
    String sql =
        "Select id,title,comment, is_income from  analytics offset " + offset + " limit " + limit;
    String countsql = "Select count(*) from analytics";
    List<Analytics> analytics = jdbcTemplate.query(sql, new AnalyticsListMapper());
    Integer count = jdbcTemplate.queryForObject(countsql, Integer.class);

    return new PaginationData<>(analytics, count);
  }

  @Override
  public Analytics getAnalyticsById(int id) {
    return null;
  }

  @Override
  public boolean update(Analytics analytics) {
    return false;
  }

  @Override
  public boolean delete(int id) {
    return false;
  }

  @Override
  public boolean create(Analytics analytics) {
    String sql = "Insert into analytics (title,comment,is_income)values(?,?,?)";
    int result =
        jdbcTemplate.update(
            sql, analytics.getTitle(), analytics.getComment(), analytics.getIsIncome() ? 1 : 0);
    return result == 1;
  }

  @Override
  public boolean fieldValueExists(String fieldName, Object value, int id) {
    return DaoHelper.fieldValueExists(jdbcTemplate, "analytics", fieldName, value, id);
  }
}
