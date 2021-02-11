package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.mappers.EmployeeMapper;
import kg.akoikelov.springmvcapp.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOSql implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAOSql(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee findById(Integer id) {
        String sql = "SELECT id, username, password, full_name, position, salary, is_working, " +
                "birthday, passport_id, affiliate_id, cashbox_id, comment, role, address, phone FROM employees WHERE id = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Employee findOneByUsernameAndPassword(String username, String password) {
        String sql = "SELECT id, username, password, full_name, position, salary, is_working, " +
                "birthday, passport_id, affiliate_id, cashbox_id, comment, role, address, phone FROM employees " +
                "WHERE username = ? and password = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), username, password);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean create(Employee employee) {
        String sql = "insert into employees (username, password, full_name, position, " +
                "salary, is_working, birthday, passport_id, affiliate_id, cashbox_id, comment, role, address, phone)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        int result = jdbcTemplate.update(sql, employee.getUserName(), employee.getPassword(),
                employee.getFullName(), employee.getPosition(), employee.getSalary(), employee.isWorking() ? 1 : 0,
                employee.getBirthday(), employee.getPassportId(), employee.getAffiliateId(),
                employee.getCashboxId(), employee.getComment(), employee.getRole(),
                employee.getAddress(), employee.getPhone());

        return result == 1;
    }

    @Override
    public boolean update(Employee employee) {
        String sql = "update employees set username=?, password=?, full_name=?, position=?, " +
                "salary=?, is_working=?, birthday=?, passport_id=?, affiliate_id=?, cashbox_id=?, comment=?, " +
                "role=?, address=?, phone=? where id = ?";

        int result = jdbcTemplate.update(sql, employee.getUserName(),
                employee.getPassword(),
                employee.getFullName(), employee.getPosition(), employee.getSalary(), employee.isWorking() ? 1 : 0,
                employee.getBirthday(), employee.getPassportId(), employee.getAffiliateId(),
                employee.getCashboxId(), employee.getComment(), employee.getRole(),
                employee.getAddress(), employee.getPhone(), employee.getId());

        return result == 1;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from employees where id = ?";

        return jdbcTemplate.update(sql, id) == 1;
    }
}
