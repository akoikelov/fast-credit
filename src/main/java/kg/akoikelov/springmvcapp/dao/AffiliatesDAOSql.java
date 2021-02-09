package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.mappers.AffiliatesMapper;
import kg.akoikelov.springmvcapp.models.Affiliate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class AffiliatesDAOSql implements AffiliatesDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AffiliatesDAOSql(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Affiliate findById(int id) {
        String sql = "Select * from Affiliates where id=?";

        return jdbcTemplate.queryForObject(sql, new AffiliatesMapper(), id);
    }

//    public boolean checkIfExists(String field, String value) {
//        String sql = "select count(*) from affiliates where " + field + " = ?";
//
//        Integer count = jdbcTemplate.queryForObject(sql, new Object[] {value}, Integer.class);
//
//        if (count == null) {
//            return false;
//        }
//
//        return true;
//
//    }

    @Override
    public boolean create(Affiliate affiliate) {
        String sql = "INSERT INTO affiliates (title,max_sum_month,max_sum_day,max_days,min_percentage,comment," +
                "phone,address,prefix,max_months)" +
                "Values(?,?,?,?,?,?,?,?,?,?)";

        int result = jdbcTemplate.update(sql, affiliate.getTitle(), affiliate.getMaxSumMonth(), affiliate.getMaxSumDay(),
                affiliate.getMaxDays(), affiliate.getMinPercentage(), affiliate.getComment(), affiliate.getPhone(),
                affiliate.getAddress(), affiliate.getPrefix(), affiliate.getMaxMonths());

        return result == 1;
    }

    @Override
    public boolean update(Affiliate affiliate) {
        int id = affiliate.getId();
        String sql = ("UPDATE Affiliates SET title=?,max_sum_month=?,max_sum_day=?,max_days=?," +
                "min_percentage=?,comment=?,phone=?,address=?,prefix=?,max_months=? WHERE id=?");
        int result = jdbcTemplate.update(sql, affiliate.getTitle(), affiliate.getMaxSumMonth(), affiliate.getMaxSumDay(),
                affiliate.getMaxDays(), affiliate.getMinPercentage(), affiliate.getComment(), affiliate.getPhone(),
                affiliate.getAddress(), affiliate.getPrefix(), affiliate.getMaxMonths(), id);

        return result == 1;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM AFFILIATES WHERE ID=?";
        int result = jdbcTemplate.update(sql, id);

        return result == 1;
    }
}
