package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.mappers.CustomerListMapper;
import kg.akoikelov.springmvcapp.mappers.CustomerMapper;
import kg.akoikelov.springmvcapp.models.Customer;
import kg.akoikelov.springmvcapp.utils.DaoHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("ALL")
@Repository
public class CustomerDAOSql implements CustomerDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDAOSql(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(Customer customer) {
        String sql =
                "insert into customer (full_name, birthday, passport_id, address, "
                        + "phone, sms_phone,fine_enabled,black_list, comment, note, weeks_note, taxi_company,"
                        + " bort_number, shift, place_of_birth, marital_status,"
                        + " partner_full_name, partner_workplace, partner_phone,"
                        + " brother_phone, sister_phone, mother_phone, father_phone, "
                        + "roommate_phone, mother_full_name, father_full_name, "
                        + "sister_full_name, brother_full_name, parent_work_place,"
                        + " work_place, work_place_more, number_of_children, actual_address,"
                        + " relatives_phones, days_salary_level, other_income, monthly_payments,"
                        + " ownership, received_credit_before, date_of_questioning, affiliate_id, "
                        + "employee_create_id, arrested_date, color, regular_comment,"
                        + " disable_fine_till_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        int result =
                jdbcTemplate.update(
                        sql,
                        customer.getFullName(),
                        customer.getBirthday(),
                        customer.getPassportId(),
                        customer.getAddress(),
                        customer.getPhone(),
                        customer.getSmsPhone(),
                        customer.isFineEnabled() ? 1 : 0,
                        customer.isBlackList() ? 1 : 0,
                        customer.getComment(),
                        customer.getNote(),
                        customer.getWeeksNote(),
                        customer.getTaxiCompany(),
                        customer.getBortNumber(),
                        customer.getShift(),
                        customer.getPlaceOfBirth(),
                        customer.getMaritalStatus(),
                        customer.getPartnerFullName(),
                        customer.getPartnerWorkplace(),
                        customer.getPartnerPhone(),
                        customer.getBrotherPhone(),
                        customer.getSisterPhone(),
                        customer.getMotherPhone(),
                        customer.getFatherPhone(),
                        customer.getRoommatePhone(),
                        customer.getMotherFullName(),
                        customer.getFatherFullName(),
                        customer.getSisterFullName(),
                        customer.getBrotherFullName(),
                        customer.getParentWorkPlace(),
                        customer.getWorkPlace(),
                        customer.getWorkPlaceMore(),
                        customer.getNumberOfChildren(),
                        customer.getActualAddress(),
                        customer.getRelativesPhones(),
                        customer.getDaysSalaryLevel(),
                        customer.getOtherIncome(),
                        customer.getMonthlyPayments(),
                        customer.getOwnership(),
                        customer.getReceivedCreditBefore(),
                        customer.getDateOfQuestioning(),
                        customer.getAffiliateId(),
                        customer.getEmployeeCreateId(),
                        customer.getIsArrested() ? 1 : 0,
                        customer.getColor(),
                        customer.getRegularComment(),
                        customer.getDisableFineTillDate());
        return result == 1;
    }

    @Override
    public boolean update(Customer customer) {
        String sql = "Update customer set full_name=?, birthday=?, passport_id=?, address=?, " +
                "phone=?, sms_phone=?,fine_enabled=?,black_list=?, comment=?, note=?, weeks_note=?, taxi_company=?," +
                " bort_number=?, shift=?, place_of_birth=?, marital_status=?, " +
                " partner_full_name=?, partner_workplace=?, partner_phone=?," +
                " brother_phone=?, sister_phone=?, mother_phone=?, father_phone=?, " +
                "roommate_phone=?, mother_full_name=?, father_full_name=?,  " +
                "sister_full_name=?, brother_full_name=?, parent_work_place=?, " +
                " work_place=?, work_place_more=?, number_of_children=?, actual_address=?, " +
                " relatives_phones=?, days_salary_level=?, other_income=?, monthly_payments=?, " +
                " ownership=?, received_credit_before=?, date_of_questioning=?, employee_update_id=? where id=?";

        int result = jdbcTemplate.update(sql, customer.getFullName(), customer.getBirthday(), customer.getPassportId(),
                customer.getAddress(), customer.getPhone(), customer.getSmsPhone(), customer.isFineEnabled() ? 1 : 0, customer.isBlackList() ? 1 : 0,
                customer.getComment(), customer.getNote(), customer.getWeeksNote(), customer.getTaxiCompany(),
                customer.getBortNumber(), customer.getShift(), customer.getPlaceOfBirth(), customer.getMaritalStatus(),
                customer.getPartnerFullName(), customer.getPartnerWorkplace(), customer.getPartnerPhone(), customer.getBrotherPhone(),
                customer.getSisterPhone(), customer.getMotherPhone(), customer.getFatherPhone(), customer.getRoommatePhone(), customer.getMotherFullName(),
                customer.getFatherFullName(), customer.getSisterFullName(), customer.getBrotherFullName(), customer.getParentWorkPlace(),
                customer.getWorkPlace(), customer.getWorkPlaceMore(), customer.getNumberOfChildren(), customer.getActualAddress(),
                customer.getRelativesPhones(), customer.getDaysSalaryLevel(), customer.getOtherIncome(), customer.getMonthlyPayments(), customer.getOwnership(),
                customer.getReceivedCreditBefore(), customer.getDateOfQuestioning(), customer.getEmployeeUpdateId(), customer.getId());

        return result == 1;
    }

    @Override
    public Customer findById(int id) {
        String sql = "select id, full_name, birthday, passport_id, address, "
                + "phone, sms_phone,fine_enabled,black_list, comment, note, weeks_note, taxi_company,"
                + " bort_number, shift, place_of_birth, marital_status,"
                + " partner_full_name, partner_workplace, partner_phone,"
                + " brother_phone, sister_phone, mother_phone, father_phone, "
                + "roommate_phone, mother_full_name, father_full_name, "
                + "sister_full_name, brother_full_name, parent_work_place,"
                + " work_place, work_place_more, number_of_children, actual_address,"
                + " relatives_phones, days_salary_level, other_income, monthly_payments,"
                + " ownership, received_credit_before, date_of_questioning from customer where id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new CustomerMapper(), id);
        } catch (EmptyResultDataAccessException e) {

        }
        return null;
    }

    @Override
    public PaginationData<Customer> getList(int page, int limit) {
        int offset = (page - 1) * limit;
        String sql =
                "Select id,full_name,birthday,passport_id,address,phone,sms_phone,fine_enabled,black_list from customer offset "
                        + offset
                        + " limit "
                        + limit;
        String countSql = "Select count(*) from customer";
        List<Customer> list = jdbcTemplate.query(sql, new CustomerListMapper());
        Integer count = jdbcTemplate.queryForObject(countSql, Integer.class);
        return new PaginationData<>(list, count);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean fieldValueExists(String fieldName, Object value, int id) {
        return DaoHelper.fieldValueExists(jdbcTemplate, "customer", fieldName, value, id);
    }
}
