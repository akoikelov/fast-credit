package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.mappers.DepositMapper;
import kg.akoikelov.springmvcapp.models.Deposit;
import kg.akoikelov.springmvcapp.utils.DaoHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepositDaoSql implements DepositDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public DepositDaoSql(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Deposit> findAll(int id) {
        String sql = "Select id,title,notes,comment,customer_id from deposits where customer_id=?";

        return jdbcTemplate.query(sql, new DepositMapper(), id);

    }

    @Override
    public PaginationData<Deposit> getAllForList(int page, int limit) {

        return null;
    }

    @Override
    public Deposit getDepositById(int id) {
        String sql = "Select id,title,notes,comment,customer_id from deposits where id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new DepositMapper(), id);
        } catch (EmptyResultDataAccessException e) {

        }
        return null;
    }

    @Override
    public boolean create(Deposit deposit) {
        String sql = "Insert into deposits (title,price,notes,comment,customer_id,employee_create_id) values(?,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql, deposit.getTitle(), deposit.getPrice(), deposit.getNotes(), deposit.getComment(),
                deposit.getCustomerId(), deposit.getEmployeeCreateId());
        return result == 1;
    }

    @Override
    public boolean update(Deposit deposit) {
        String sql = "Update deposits set title=?,notes=?,price=?,comment=?,employee_update_id=? where id=?";
        int result = jdbcTemplate.update(sql, deposit.getTitle(),
                deposit.getNotes(), deposit.getPrice(),
                deposit.getComment(), deposit.getEmployeeUpdateId(), deposit.getId());
        return result == 1;
    }


    @Override
    public boolean fieldValueExists(String fieldName, Object value, int id) {
        return DaoHelper.fieldValueExists(jdbcTemplate, "deposit", fieldName, value, id);
    }
}
