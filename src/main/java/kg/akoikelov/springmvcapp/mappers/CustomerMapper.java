package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getInt("id"));
        customer.setFullName(resultSet.getString("full_name"));
        customer.setBirthday(resultSet.getDate("birthday"));
        customer.setPassportId(resultSet.getString("passport_id"));
        customer.setAddress(resultSet.getString("address"));
        customer.setPhone(resultSet.getString("phone"));
        customer.setSmsPhone(resultSet.getString("sms_phone"));
        customer.setFineEnabled(resultSet.getBoolean("fine_enabled"));
        customer.setBlackList(resultSet.getBoolean("black_list"));
        customer.setComment(resultSet.getString("comment"));
        customer.setNote(resultSet.getString("note"));
        customer.setWeeksNote(resultSet.getString("weeks_note"));
        customer.setTaxiCompany(resultSet.getString("taxi_company"));
        customer.setBortNumber(resultSet.getString("bort_number"));
        customer.setShift(resultSet.getString("shift"));
        customer.setPlaceOfBirth(resultSet.getString("place_of_birth"));
        customer.setMaritalStatus(resultSet.getString("marital_status"));
        customer.setPartnerFullName(resultSet.getString("partner_full_name"));
        customer.setPartnerWorkplace(resultSet.getString("partner_workplace"));
        customer.setPartnerPhone(resultSet.getString("partner_phone"));
        customer.setBrotherPhone(resultSet.getString("brother_phone"));
        customer.setSisterPhone(resultSet.getString("sister_phone"));
        customer.setMotherPhone(resultSet.getString("mother_phone"));
        customer.setFatherPhone(resultSet.getString("father_phone"));
        customer.setRoommatePhone(resultSet.getString("roommate_phone"));
        customer.setMotherFullName(resultSet.getString("mother_full_name"));
        customer.setFatherFullName(resultSet.getString("father_full_name"));
        customer.setSisterFullName(resultSet.getString("sister_full_name"));
        customer.setBrotherFullName(resultSet.getString("brother_full_name"));
        customer.setParentWorkPlace(resultSet.getString("parent_work_place"));
        customer.setWorkPlace(resultSet.getString("work_place"));
        customer.setWorkPlaceMore(resultSet.getString("work_place_more"));
        customer.setNumberOfChildren(resultSet.getInt("number_of_children"));
        customer.setActualAddress(resultSet.getString("actual_address"));
        customer.setRelativesPhones(resultSet.getString("relatives_phones"));
        customer.setDaysSalaryLevel(resultSet.getInt("days_salary_level"));
        customer.setOtherIncome(resultSet.getString("other_income"));
        customer.setMonthlyPayments(resultSet.getString("monthly_payments"));
        customer.setOwnership(resultSet.getString("ownership"));
        customer.setReceivedCreditBefore(resultSet.getString("received_credit_before"));
        customer.setDateOfQuestioning(resultSet.getDate("date_of_questioning"));

        return customer;
    }
}
