package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.mappers.AffiliatesListMapper;
import kg.akoikelov.springmvcapp.mappers.AffiliatesListMapperForSelect;
import kg.akoikelov.springmvcapp.mappers.AffiliatesMapper;
import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.utils.DaoHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AffiliatesDAOSql implements AffiliatesDAO {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public AffiliatesDAOSql(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Affiliate findById(int id) {
    String sql =
        "select id, title,max_sum_month,max_sum_day,max_days,min_percentage,comment,"
            + "phone,address,prefix,max_months from affiliates where id=?";

    try {
      return jdbcTemplate.queryForObject(sql, new AffiliatesMapper(), id);
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public PaginationData<Affiliate> findForList(int page, int limit) {
    int offset = (page - 1) * limit;
    String sql =
        "SELECT id, title, max_sum_day, max_sum_month from affiliates offset "
            + offset
            + " limit "
            + limit;
    String countSql = "SELECT count(*) from affiliates";

    List<Affiliate> affiliates = jdbcTemplate.query(sql, new AffiliatesListMapper());
    Integer allCount = jdbcTemplate.queryForObject(countSql, Integer.class);

    return new PaginationData<>(affiliates, allCount);
  }

  @Override
  public List<Affiliate> findAllForSelect() {
    String sql = "SElECT id, title from affiliates";

    return jdbcTemplate.query(sql, new AffiliatesListMapperForSelect());
  }

  @Override
  public boolean create(Affiliate affiliate) {
    String sql =
        "INSERT INTO affiliates (title,max_sum_month,max_sum_day,max_days,min_percentage,comment,"
            + "phone,address,prefix,max_months)"
            + "Values(?,?,?,?,?,?,?,?,?,?)";

    int result =
        jdbcTemplate.update(
            sql,
            affiliate.getTitle(),
            affiliate.getMaxSumMonth(),
            affiliate.getMaxSumDay(),
            affiliate.getMaxDays(),
            affiliate.getMinPercentage(),
            affiliate.getComment(),
            affiliate.getPhone(),
            affiliate.getAddress(),
            affiliate.getPrefix(),
            affiliate.getMaxMonths());

    return result == 1;
  }

  @Override
  public boolean update(Affiliate affiliate) {
    int id = affiliate.getId();
    String sql =
        ("UPDATE Affiliates SET title=?,max_sum_month=?,max_sum_day=?,max_days=?,"
            + "min_percentage=?,comment=?,phone=?,address=?,prefix=?,max_months=? WHERE id=?");
    int result =
        jdbcTemplate.update(
            sql,
            affiliate.getTitle(),
            affiliate.getMaxSumMonth(),
            affiliate.getMaxSumDay(),
            affiliate.getMaxDays(),
            affiliate.getMinPercentage(),
            affiliate.getComment(),
            affiliate.getPhone(),
            affiliate.getAddress(),
            affiliate.getPrefix(),
            affiliate.getMaxMonths(),
            id);

    return result == 1;
  }

  @Override
  public boolean delete(int id) {
    String sql = "DELETE FROM AFFILIATES WHERE ID=?";
    int result = jdbcTemplate.update(sql, id);

    return result == 1;
  }

  @Override
  public boolean fieldValueExists(String fieldName, Object value, int id) {
    return DaoHelper.fieldValueExists(jdbcTemplate, "affiliates", fieldName, value, id);
  }
}
