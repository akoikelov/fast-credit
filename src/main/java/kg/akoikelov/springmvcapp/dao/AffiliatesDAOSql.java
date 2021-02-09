package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.models.Affiliate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("affdaosql")
public class AffiliatesDAOSql implements AffiliatesDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AffiliatesDAOSql(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Affiliate findById(int id) {

        return null;
    }

    @Override
    public List<Affiliate> findAll() {
        return null;
    }

    @Override
    public boolean create(Affiliate affiliate) {
        final String sql = String.format("INSERT INTO %s (title, max_sum_month, max_sum_day, max_days, max_months, " +
                                        "min_percentage, prefix) VALUES (?,?,?,?,?,?,?)", this.getTableName());

        final int result = jdbcTemplate.update(sql, affiliate.getTitle(), affiliate.getMaxSumMonth(), affiliate.getMaxSumDay(),
                            affiliate.getMaxDays(), affiliate.getMaxMonths(), affiliate.getMinPercentage(), affiliate.getPrefix());

        System.out.println("aff insert " + result);

        return true;
    }

    @Override
    public boolean update(int id, Affiliate affiliate) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public String getTableName() {
        return "affiliates";
    }
}
