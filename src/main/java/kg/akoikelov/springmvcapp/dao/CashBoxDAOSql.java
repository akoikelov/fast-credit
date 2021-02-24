package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.mappers.CashBoxMapper;
import kg.akoikelov.springmvcapp.mappers.CashBoxMapperForList;
import kg.akoikelov.springmvcapp.mappers.CashBoxMapperForSelect;
import kg.akoikelov.springmvcapp.models.CashBox;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.dao.EmptyResultDataAccessException;
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
  public PaginationData<CashBox> getAllForList(int page, int limit) {
    int offset = (page - 1) * limit;
    String sql =
        "Select cashboxes.id,cashboxes.title,a.title as aff_title,cashboxes.comment "
            + "from cashboxes join affiliates a on a.id=cashboxes.affiliate_id offset "
            + offset
            + " limit "
            + limit;
    String countSql = "Select count(*) from cashboxes";
    List<CashBox> cashBoxes = jdbcTemplate.query(sql, new CashBoxMapperForList());
    Integer allCount = jdbcTemplate.queryForObject(countSql, Integer.class);

    return new PaginationData<>(cashBoxes, allCount);
  }

  @Override
  public CashBox getCashBoxById(int id) {
    String sql = "Select id,title,affiliate_id,comment from cashboxes where id=?";

    try {
      return jdbcTemplate.queryForObject(sql, new CashBoxMapper(), id);
    } catch (EmptyResultDataAccessException e) {

    }
    return null;
  }

  @Override
  public boolean create(CashBox cashBox) {
    String sql = "Insert into cashboxes (title,affiliate_id,comment)" + "values(?,?,?)";
    int result =
        jdbcTemplate.update(
            sql, cashBox.getTitle(), cashBox.getAffiliateId(), cashBox.getComment());
    return result == 1;
  }

  @Override
  public boolean fieldValueExists(String fieldName, Object value, int id) {
    return false;
  }
}
