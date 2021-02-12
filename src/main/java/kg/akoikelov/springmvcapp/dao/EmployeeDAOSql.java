package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.utils.PaginationData;
import kg.akoikelov.springmvcapp.mappers.EmployeeListMapper;
import kg.akoikelov.springmvcapp.mappers.EmployeeMapper;
import kg.akoikelov.springmvcapp.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOSql implements EmployeeDAO {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public EmployeeDAOSql(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Employee findById(Integer id) {
    String sql =
        "SELECT id, username, password, full_name, position, salary, is_working, "
            + "birthday, passport_id, affiliate_id, cashbox_id, comment, role, address, phone FROM employees WHERE id = ?";

    try {
      return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public PaginationData<Employee> findForList(int page, int limit) {
    int offset = (page - 1) * limit;
    String sql =
        "SELECT id,username,full_name,salary,birthday,phone from employees offset "
            + offset
            + " limit "
            + limit;
    String countSql = "SELECT count(*) from employees";

    List<Employee> employees = jdbcTemplate.query(sql, new EmployeeListMapper());
    Integer allCount = jdbcTemplate.queryForObject(countSql, Integer.class);

    return new PaginationData<>(employees, allCount);
  }

  @Override
  public Employee findOneByUsernameAndPassword(String username, String password) {
    String sql =
        "SELECT id, username, password, full_name, position, salary, is_working, "
            + "birthday, passport_id, affiliate_id, cashbox_id, comment, role, address, phone FROM employees "
            + "WHERE username = ? and password = ?";

    try {
      return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), username, password);
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public boolean create(Employee employee) {
    String sql =
        "insert into employees (username, password, full_name, position, "
            + "salary, is_working, birthday, passport_id, affiliate_id, cashbox_id, comment, role, address, phone)"
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    int result =
        jdbcTemplate.update(
            sql,
            employee.getUserName(),
            employee.getPassword(),
            employee.getFullName(),
            employee.getPosition(),
            employee.getSalary(),
            employee.isWorking() ? 1 : 0,
            employee.getBirthday(),
            employee.getPassportId(),
            employee.getAffiliateId(),
            employee.getCashboxId(),
            employee.getComment(),
            employee.getRole(),
            employee.getAddress(),
            employee.getPhone());

    return result == 1;
  }

  @Override
  public boolean update(Employee employee) {
    String sql =
        "update employees set username=?, password=?, full_name=?, position=?, "
            + "salary=?, is_working=?, birthday=?, passport_id=?, affiliate_id=?, cashbox_id=?, comment=?, "
            + "role=?, address=?, phone=? where id = ?";

    int result =
        jdbcTemplate.update(
            sql,
            employee.getUserName(),
            employee.getPassword(),
            employee.getFullName(),
            employee.getPosition(),
            employee.getSalary(),
            employee.isWorking() ? 1 : 0,
            employee.getBirthday(),
            employee.getPassportId(),
            employee.getAffiliateId(),
            employee.getCashboxId(),
            employee.getComment(),
            employee.getRole(),
            employee.getAddress(),
            employee.getPhone(),
            employee.getId());

    return result == 1;
  }

  @Override
  public boolean delete(int id) {
    String sql = "delete from employees where id = ?";

    return jdbcTemplate.update(sql, id) == 1;
  }
}

// a -> b -> c -> h -> j             // a -> b -> c -> h -> j develop
// a -> b -> c -> h -> j  -> d -> e             // a -> b -> c -> d -> e your
