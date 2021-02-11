package kg.akoikelov.springmvcapp.dao;

import br.com.six2six.fixturefactory.Fixture;
import kg.akoikelov.springmvcapp.mappers.EmployeeMapper;
import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.models.CashBox;
import kg.akoikelov.springmvcapp.models.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOSqlTest extends DAOSqlTest {

    @Autowired
    private EmployeeDAOSql employeeDAOSql;

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    void findById() {
        Affiliate testAffiliate = Fixture.from(Affiliate.class).gimme("valid");
        CashBox testCashbox = Fixture.from(CashBox.class).gimme("valid");
        Employee testEmployee = Fixture.from(Employee.class).gimme("valid");

        String affiliateSql = "INSERT INTO affiliates (title,max_sum_month,max_sum_day,max_days,min_percentage,comment," +
                "phone,address,prefix,max_months)" +
                "Values(?,?,?,?,?,?,?,?,?,?)";
        String cashboxSql = "INSERT INTO cashboxes (title, comment, affiliate_id) values(?, ?, ?)";

        String employeeInsertSql = "insert into employees (username, password, full_name, position, " +
                "salary, is_working, birthday, passport_id, affiliate_id, cashbox_id, comment, role, address, phone)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(affiliateSql, testAffiliate.getTitle(), testAffiliate.getMaxSumMonth(),
                testAffiliate.getMaxSumDay(), testAffiliate.getMaxDays(), testAffiliate.getMinPercentage(),
                testAffiliate.getComment(), testAffiliate.getPhone(), testAffiliate.getAddress(),
                testAffiliate.getPrefix(), testAffiliate.getMaxMonths());

        Integer newCreatedAffiliateId = jdbcTemplate.queryForObject("select id from affiliates limit 1", Integer.class);

        assertNotNull(newCreatedAffiliateId);

        testCashbox.setAffiliateId(newCreatedAffiliateId);

        jdbcTemplate.update(cashboxSql, testCashbox.getTitle(), testCashbox.getComment(),
                testCashbox.getAffiliateId());

        Integer newCreatedCashboxId = jdbcTemplate.queryForObject("select id from cashboxes limit 1", Integer.class);

        assertNotNull(newCreatedCashboxId);

        testEmployee.setAffiliateId(newCreatedAffiliateId);
        testEmployee.setCashboxId(newCreatedCashboxId);

        jdbcTemplate.update(employeeInsertSql, testEmployee.getUserName(), testEmployee.getPassword(),
                testEmployee.getFullName(), testEmployee.getPosition(), testEmployee.getSalary(), testEmployee.isWorking() ? 1 : 0,
                testEmployee.getBirthday(), testEmployee.getPassportId(), testEmployee.getAffiliateId(),
                testEmployee.getCashboxId(), testEmployee.getComment(), testEmployee.getRole(),
                testEmployee.getAddress(), testEmployee.getPhone());

        Integer newCreatedEmployeeId = jdbcTemplate.queryForObject("select id from employees limit 1", Integer.class);

        assertNotNull(newCreatedEmployeeId);

        Employee foundEmployee = employeeDAOSql.findById(newCreatedEmployeeId);

        assertNotNull(foundEmployee);

        assertEquals(foundEmployee.getId(), newCreatedEmployeeId);
        assertEquals(foundEmployee.getUserName(), testEmployee.getUserName());
        assertEquals(foundEmployee.getPassword(), testEmployee.getPassword());
        assertEquals(foundEmployee.getFullName(), testEmployee.getFullName());
        assertEquals(foundEmployee.getPosition(), testEmployee.getPosition());
        assertEquals(foundEmployee.getSalary(), testEmployee.getSalary());
        assertEquals(foundEmployee.isWorking(), testEmployee.isWorking());
        assertEquals(simpleDateFormat.format(foundEmployee.getBirthday()), simpleDateFormat.format(testEmployee.getBirthday()));
        assertEquals(foundEmployee.getPassportId(), testEmployee.getPassportId());
        assertEquals(foundEmployee.getAffiliateId(), testEmployee.getAffiliateId());
        assertEquals(foundEmployee.getCashboxId(), testEmployee.getCashboxId());
        assertEquals(foundEmployee.getComment(), testEmployee.getComment());
        assertEquals(foundEmployee.getRole(), testEmployee.getRole());
        assertEquals(foundEmployee.getAddress(), testEmployee.getAddress());
        assertEquals(foundEmployee.getPhone(), testEmployee.getPhone());
    }

    @Test
    void findByIdNotFound() {
        Employee foundEmployee = employeeDAOSql.findById(100);

        assertNull(foundEmployee);
    }

    @Test
    void findOneByUsernameAndPassword() {
        Affiliate testAffiliate = Fixture.from(Affiliate.class).gimme("valid");
        CashBox testCashbox = Fixture.from(CashBox.class).gimme("valid");
        Employee testEmployee = Fixture.from(Employee.class).gimme("valid");

        String affiliateSql = "INSERT INTO affiliates (title,max_sum_month,max_sum_day,max_days,min_percentage,comment," +
                "phone,address,prefix,max_months)" +
                "Values(?,?,?,?,?,?,?,?,?,?)";
        String cashboxSql = "INSERT INTO cashboxes (title, comment, affiliate_id) values(?, ?, ?)";

        String employeeInsertSql = "insert into employees (username, password, full_name, position, " +
                "salary, is_working, birthday, passport_id, affiliate_id, cashbox_id, comment, role, address, phone)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(affiliateSql, testAffiliate.getTitle(), testAffiliate.getMaxSumMonth(),
                testAffiliate.getMaxSumDay(), testAffiliate.getMaxDays(), testAffiliate.getMinPercentage(),
                testAffiliate.getComment(), testAffiliate.getPhone(), testAffiliate.getAddress(),
                testAffiliate.getPrefix(), testAffiliate.getMaxMonths());

        Integer newCreatedAffiliateId = jdbcTemplate.queryForObject("select id from affiliates limit 1", Integer.class);

        assertNotNull(newCreatedAffiliateId);

        testCashbox.setAffiliateId(newCreatedAffiliateId);

        jdbcTemplate.update(cashboxSql, testCashbox.getTitle(), testCashbox.getComment(),
                testCashbox.getAffiliateId());

        Integer newCreatedCashboxId = jdbcTemplate.queryForObject("select id from cashboxes limit 1", Integer.class);

        assertNotNull(newCreatedCashboxId);

        testEmployee.setAffiliateId(newCreatedAffiliateId);
        testEmployee.setCashboxId(newCreatedCashboxId);

        jdbcTemplate.update(employeeInsertSql, testEmployee.getUserName(), testEmployee.getPassword(),
                testEmployee.getFullName(), testEmployee.getPosition(), testEmployee.getSalary(), testEmployee.isWorking() ? 1 : 0,
                testEmployee.getBirthday(), testEmployee.getPassportId(), testEmployee.getAffiliateId(),
                testEmployee.getCashboxId(), testEmployee.getComment(), testEmployee.getRole(),
                testEmployee.getAddress(), testEmployee.getPhone());

        Integer newCreatedEmployeeId = jdbcTemplate.queryForObject("select id from employees limit 1", Integer.class);

        assertNotNull(newCreatedEmployeeId);

        Employee foundEmployee = employeeDAOSql.findOneByUsernameAndPassword(testEmployee.getUserName(), testEmployee.getPassword());

        assertNotNull(foundEmployee);

        assertEquals(foundEmployee.getId(), newCreatedEmployeeId);
        assertEquals(foundEmployee.getUserName(), testEmployee.getUserName());
        assertEquals(foundEmployee.getPassword(), testEmployee.getPassword());
        assertEquals(foundEmployee.getFullName(), testEmployee.getFullName());
        assertEquals(foundEmployee.getPosition(), testEmployee.getPosition());
        assertEquals(foundEmployee.getSalary(), testEmployee.getSalary());
        assertEquals(foundEmployee.isWorking(), testEmployee.isWorking());
        assertEquals(simpleDateFormat.format(foundEmployee.getBirthday()), simpleDateFormat.format(testEmployee.getBirthday()));
        assertEquals(foundEmployee.getPassportId(), testEmployee.getPassportId());
        assertEquals(foundEmployee.getAffiliateId(), testEmployee.getAffiliateId());
        assertEquals(foundEmployee.getCashboxId(), testEmployee.getCashboxId());
        assertEquals(foundEmployee.getComment(), testEmployee.getComment());
        assertEquals(foundEmployee.getRole(), testEmployee.getRole());
        assertEquals(foundEmployee.getAddress(), testEmployee.getAddress());
        assertEquals(foundEmployee.getPhone(), testEmployee.getPhone());
    }

    @Test
    void findOneByUsernameAndPasswordNotFound() {
        Employee employee = employeeDAOSql.findOneByUsernameAndPassword("test", "test");

        assertNull(employee);
    }

    @Test
    void create() {
        Affiliate testAffiliate = Fixture.from(Affiliate.class).gimme("valid");
        CashBox testCashbox = Fixture.from(CashBox.class).gimme("valid");
        Employee newEmployee = Fixture.from(Employee.class).gimme("valid");

        String affiliateSql = "INSERT INTO affiliates (title,max_sum_month,max_sum_day,max_days,min_percentage,comment," +
                "phone,address,prefix,max_months)" +
                "Values(?,?,?,?,?,?,?,?,?,?)";
        String cashboxSql = "INSERT INTO cashboxes (title, comment, affiliate_id) values(?, ?, ?)";

        jdbcTemplate.update(affiliateSql, testAffiliate.getTitle(), testAffiliate.getMaxSumMonth(),
                testAffiliate.getMaxSumDay(), testAffiliate.getMaxDays(), testAffiliate.getMinPercentage(),
                testAffiliate.getComment(), testAffiliate.getPhone(), testAffiliate.getAddress(),
                testAffiliate.getPrefix(), testAffiliate.getMaxMonths());

        Integer newCreatedAffiliateId = jdbcTemplate.queryForObject("select id from affiliates limit 1", Integer.class);

        assertNotNull(newCreatedAffiliateId);

        testCashbox.setAffiliateId(newCreatedAffiliateId);

        jdbcTemplate.update(cashboxSql, testCashbox.getTitle(), testCashbox.getComment(),
                testCashbox.getAffiliateId());

        Integer newCreatedCashboxId = jdbcTemplate.queryForObject("select id from cashboxes limit 1", Integer.class);

        assertNotNull(newCreatedCashboxId);

        newEmployee.setAffiliateId(newCreatedAffiliateId);
        newEmployee.setCashboxId(newCreatedCashboxId);

        boolean result = employeeDAOSql.create(newEmployee);

        assertTrue(result);

        Integer newCreatedEmployeeId = jdbcTemplate.queryForObject("select id from employees limit 1", Integer.class);

        assertNotNull(newCreatedEmployeeId);

        String getEmployeeSql = "SELECT id, username, password, full_name, position, salary, is_working, " +
                "birthday, passport_id, affiliate_id, cashbox_id, comment, role, address, phone FROM employees WHERE id = ?";

        Employee checkEmployee = jdbcTemplate.queryForObject(getEmployeeSql, new EmployeeMapper(), newCreatedEmployeeId);

        assertNotNull(checkEmployee);

        assertEquals(checkEmployee.getUserName(), newEmployee.getUserName());
        assertEquals(checkEmployee.getPassword(), newEmployee.getPassword());
        assertEquals(checkEmployee.getFullName(), newEmployee.getFullName());
        assertEquals(checkEmployee.getPosition(), newEmployee.getPosition());
        assertEquals(checkEmployee.getSalary(), newEmployee.getSalary());
        assertEquals(checkEmployee.isWorking(), newEmployee.isWorking());
        assertEquals(simpleDateFormat.format(checkEmployee.getBirthday()), simpleDateFormat.format(newEmployee.getBirthday()));
        assertEquals(checkEmployee.getPassportId(), newEmployee.getPassportId());
        assertEquals(checkEmployee.getAffiliateId(), newEmployee.getAffiliateId());
        assertEquals(checkEmployee.getCashboxId(), newEmployee.getCashboxId());
        assertEquals(checkEmployee.getComment(), newEmployee.getComment());
        assertEquals(checkEmployee.getRole(), newEmployee.getRole());
        assertEquals(checkEmployee.getAddress(), newEmployee.getAddress());
        assertEquals(checkEmployee.getPhone(), newEmployee.getPhone());
    }

    @Test
    void update() {
        Affiliate testAffiliate = Fixture.from(Affiliate.class).gimme("valid");
        CashBox testCashbox = Fixture.from(CashBox.class).gimme("valid");
        Employee testEmployee = Fixture.from(Employee.class).gimme("valid");

        String affiliateSql = "INSERT INTO affiliates (title,max_sum_month,max_sum_day,max_days,min_percentage,comment," +
                "phone,address,prefix,max_months)" +
                "Values(?,?,?,?,?,?,?,?,?,?)";
        String cashboxSql = "INSERT INTO cashboxes (title, comment, affiliate_id) values(?, ?, ?)";

        String employeeInsertSql = "insert into employees (username, password, full_name, position, " +
                "salary, is_working, birthday, passport_id, affiliate_id, cashbox_id, comment, role, address, phone)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(affiliateSql, testAffiliate.getTitle(), testAffiliate.getMaxSumMonth(),
                testAffiliate.getMaxSumDay(), testAffiliate.getMaxDays(), testAffiliate.getMinPercentage(),
                testAffiliate.getComment(), testAffiliate.getPhone(), testAffiliate.getAddress(),
                testAffiliate.getPrefix(), testAffiliate.getMaxMonths());

        Integer newCreatedAffiliateId = jdbcTemplate.queryForObject("select id from affiliates limit 1", Integer.class);

        assertNotNull(newCreatedAffiliateId);

        testCashbox.setAffiliateId(newCreatedAffiliateId);

        jdbcTemplate.update(cashboxSql, testCashbox.getTitle(), testCashbox.getComment(),
                testCashbox.getAffiliateId());

        Integer newCreatedCashboxId = jdbcTemplate.queryForObject("select id from cashboxes limit 1", Integer.class);

        assertNotNull(newCreatedCashboxId);

        testEmployee.setAffiliateId(newCreatedAffiliateId);
        testEmployee.setCashboxId(newCreatedCashboxId);

        jdbcTemplate.update(employeeInsertSql, testEmployee.getUserName(), testEmployee.getPassword(),
                testEmployee.getFullName(), testEmployee.getPosition(), testEmployee.getSalary(), testEmployee.isWorking() ? 1 : 0,
                testEmployee.getBirthday(), testEmployee.getPassportId(), testEmployee.getAffiliateId(),
                testEmployee.getCashboxId(), testEmployee.getComment(), testEmployee.getRole(),
                testEmployee.getAddress(), testEmployee.getPhone());

        Integer newCreatedEmployeeId = jdbcTemplate.queryForObject("select id from employees limit 1", Integer.class);

        assertNotNull(newCreatedEmployeeId);
        
        Employee updatedEmployee = new Employee(newCreatedEmployeeId);
        updatedEmployee.setUserName("update username");
        updatedEmployee.setPassword("update password");
        updatedEmployee.setFullName("update fullname");
        updatedEmployee.setPosition("update position");
        updatedEmployee.setSalary(100000);
        updatedEmployee.setWorking(false);
        updatedEmployee.setBirthday(new Date());
        updatedEmployee.setPassportId("updated passport");
        updatedEmployee.setAffiliateId(newCreatedAffiliateId);
        updatedEmployee.setCashboxId(newCreatedCashboxId);
        updatedEmployee.setComment("update comment");
        updatedEmployee.setRole("update role");
        updatedEmployee.setAddress("update address");
        updatedEmployee.setPhone("update phone");

        boolean result = employeeDAOSql.update(updatedEmployee);

        assertTrue(result);

        String getEmployeeSql = "SELECT id, username, password, full_name, position, salary, is_working, " +
                "birthday, passport_id, affiliate_id, cashbox_id, comment, role, address, phone FROM employees WHERE id = ?";

        Employee checkEmployee = jdbcTemplate.queryForObject(getEmployeeSql, new EmployeeMapper(), newCreatedEmployeeId);

        assertNotNull(checkEmployee);

        assertEquals(checkEmployee.getUserName(), updatedEmployee.getUserName());
        assertEquals(checkEmployee.getPassword(), updatedEmployee.getPassword());
        assertEquals(checkEmployee.getFullName(), updatedEmployee.getFullName());
        assertEquals(checkEmployee.getPosition(), updatedEmployee.getPosition());
        assertEquals(checkEmployee.getSalary(), updatedEmployee.getSalary());
        assertEquals(checkEmployee.isWorking(), updatedEmployee.isWorking());
        assertEquals(simpleDateFormat.format(checkEmployee.getBirthday()), simpleDateFormat.format(updatedEmployee.getBirthday()));
        assertEquals(checkEmployee.getPassportId(), updatedEmployee.getPassportId());
        assertEquals(checkEmployee.getAffiliateId(), updatedEmployee.getAffiliateId());
        assertEquals(checkEmployee.getCashboxId(), updatedEmployee.getCashboxId());
        assertEquals(checkEmployee.getComment(), updatedEmployee.getComment());
        assertEquals(checkEmployee.getRole(), updatedEmployee.getRole());
        assertEquals(checkEmployee.getAddress(), updatedEmployee.getAddress());
        assertEquals(checkEmployee.getPhone(), updatedEmployee.getPhone());
    }

    @Test
    void delete() {
        Affiliate testAffiliate = Fixture.from(Affiliate.class).gimme("valid");
        CashBox testCashbox = Fixture.from(CashBox.class).gimme("valid");
        Employee testEmployee = Fixture.from(Employee.class).gimme("valid");

        String affiliateSql = "INSERT INTO affiliates (title,max_sum_month,max_sum_day,max_days,min_percentage,comment," +
                "phone,address,prefix,max_months)" +
                "Values(?,?,?,?,?,?,?,?,?,?)";
        String cashboxSql = "INSERT INTO cashboxes (title, comment, affiliate_id) values(?, ?, ?)";

        String employeeInsertSql = "insert into employees (username, password, full_name, position, " +
                "salary, is_working, birthday, passport_id, affiliate_id, cashbox_id, comment, role, address, phone)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(affiliateSql, testAffiliate.getTitle(), testAffiliate.getMaxSumMonth(),
                testAffiliate.getMaxSumDay(), testAffiliate.getMaxDays(), testAffiliate.getMinPercentage(),
                testAffiliate.getComment(), testAffiliate.getPhone(), testAffiliate.getAddress(),
                testAffiliate.getPrefix(), testAffiliate.getMaxMonths());

        Integer newCreatedAffiliateId = jdbcTemplate.queryForObject("select id from affiliates limit 1", Integer.class);

        assertNotNull(newCreatedAffiliateId);

        testCashbox.setAffiliateId(newCreatedAffiliateId);

        jdbcTemplate.update(cashboxSql, testCashbox.getTitle(), testCashbox.getComment(),
                testCashbox.getAffiliateId());

        Integer newCreatedCashboxId = jdbcTemplate.queryForObject("select id from cashboxes limit 1", Integer.class);

        assertNotNull(newCreatedCashboxId);

        testEmployee.setAffiliateId(newCreatedAffiliateId);
        testEmployee.setCashboxId(newCreatedCashboxId);

        jdbcTemplate.update(employeeInsertSql, testEmployee.getUserName(), testEmployee.getPassword(),
                testEmployee.getFullName(), testEmployee.getPosition(), testEmployee.getSalary(), testEmployee.isWorking() ? 1 : 0,
                testEmployee.getBirthday(), testEmployee.getPassportId(), testEmployee.getAffiliateId(),
                testEmployee.getCashboxId(), testEmployee.getComment(), testEmployee.getRole(),
                testEmployee.getAddress(), testEmployee.getPhone());

        Integer newCreatedEmployeeId = jdbcTemplate.queryForObject("select id from employees limit 1", Integer.class);

        assertNotNull(newCreatedEmployeeId);

        boolean result = employeeDAOSql.delete(newCreatedEmployeeId);

        assertTrue(result);

        Integer employeesCount = jdbcTemplate.queryForObject("select count(id) from employees", Integer.class);

        assertEquals(employeesCount, 0);
    }
}