package kg.akoikelov.springmvcapp.rest.serializers;

import kg.akoikelov.springmvcapp.dao.EmployeeDAO;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.validation.Exist;
import kg.akoikelov.springmvcapp.validation.FieldsValueMatch;
import kg.akoikelov.springmvcapp.validation.Unique;
import kg.akoikelov.springmvcapp.validation.ValueFromList;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "repeatPassword",
                message = "Пароль не совпадает"),
})
@Unique.List({
        @Unique(
                fieldName = "userName",
                service = EmployeeDAO.class,
                message = "Сотрудник с таким именем есть")
})
@Component
public class EmployeeSerializer {

    @NotNull
    @NotBlank
    private String userName;
    private int id;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String repeatPassword;
    @NotNull
    @NotBlank
    private String fullName;

    @NotNull
    @NotBlank
    @ValueFromList(
            allowedValues = "it,director,manager,polomoika",
            message = "Не допустимое значение")
    private String position;

    @Min(value = 0)
    private int salary;

    private boolean isWorking;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date birthday;

    private String passportId;
    private String address;
    private String phone;
    @Exist(message = "Филиала такого нет",
    tableName = "affiliates")
    private int affiliateId;
    @Exist(message = "Кассы такого нет",
            tableName = "cashboxes")
    private int cashboxId;
    private String comment;
    @ValueFromList(
            allowedValues = "ROLE_USER",
            message = "Не допустимое значение")
    private String role;
    private boolean enabled = true;

    public EmployeeSerializer() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(boolean working) {
        isWorking = working;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(int affiliateId) {
        this.affiliateId = affiliateId;
    }

    public int getCashboxId() {
        return cashboxId;
    }

    public void setCashboxId(int cashboxId) {
        this.cashboxId = cashboxId;
    }

    public Employee build() {
        return new Employee(
                userName,
                password,
                fullName,
                position,
                salary,
                isWorking,
                birthday,
                passportId,
                address,
                phone,
                affiliateId,
                cashboxId,
                comment,
                enabled,
                role);
    }
}
