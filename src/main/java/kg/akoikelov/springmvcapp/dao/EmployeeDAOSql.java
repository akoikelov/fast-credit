package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.mappers.EmployeeListMapper;
import kg.akoikelov.springmvcapp.mappers.EmployeeMapper;
import kg.akoikelov.springmvcapp.mappers.ProfileMapper;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.utils.DaoHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOSql implements EmployeeDAO {

  private final JdbcTemplate jdbcTemplate;

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
            + "salary, is_working, birthday, passport_id, affiliate_id, cashbox_id, comment,enabled, address, phone)"
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);insert into authorities (username, authority) values (?,?)";

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
            employee.isEnabled() ? 1 : 0,
            employee.getAddress(),
            employee.getPhone(),
            employee.getUserName(),
            employee.getRole());

    return result == 1;
  }

  @Transactional
  @Override
  public boolean update(Employee employee) {
    String sql =
        "update employees set  full_name=?, position=?, "
            + "salary=?, is_working=?, birthday=?, passport_id=?, affiliate_id=?, cashbox_id=?, comment=?, "
            + " address=?, phone=? where id = ?;update  authorities set authority=? where username=? ";

    int result =
        jdbcTemplate.update(
            sql,
            employee.getFullName(),
            employee.getPosition(),
            employee.getSalary(),
            employee.isWorking() ? 1 : 0,
            employee.getBirthday(),
            employee.getPassportId(),
            employee.getAffiliateId(),
            employee.getCashboxId(),
            employee.getComment(),
            employee.getAddress(),
            employee.getPhone(),
            employee.getId(),
            employee.getRole(),
            employee.getUserName());

    return result == 1;
  }

  @Override
  public boolean delete(int id) {
    String sql = "delete from employees where id = ?";

    return jdbcTemplate.update(sql, id) == 1;
  }

  @Override
  public String findRoleForUserName(String username) {
    String sql = "Select authority from authorities where username=? ";
    try {
      return jdbcTemplate.queryForObject(sql, String.class, username);
    } catch (EmptyResultDataAccessException e) {

    }
    return null;
  }

  @Override
  public boolean fieldValueExists(String fieldName, Object value, int id) {
    return DaoHelper.fieldValueExists(jdbcTemplate, "employees", fieldName, value, id);
  }

  @Override
  public Employee findByUserName(String username) {
    String sql =
        "SELECT id, username, password, full_name, "
            + "birthday, passport_id, comment, address, phone FROM employees "
            + "WHERE username = ? ";

    try {
      return jdbcTemplate.queryForObject(sql, new ProfileMapper(), username);
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public boolean updateProfile(Employee employee) {
    String sql =
        "update employees set  full_name=?,password=?,birthday=?, passport_id=?,  comment=?, "
            + " address=?, phone=? where username = ?";

    int result =
        jdbcTemplate.update(
            sql,
            employee.getFullName(),
            employee.getPassword(),
            employee.getBirthday(),
            employee.getPassportId(),
            employee.getComment(),
            employee.getAddress(),
            employee.getPhone(),
            employee.getUserName());
    return result == 1;
  }
}
