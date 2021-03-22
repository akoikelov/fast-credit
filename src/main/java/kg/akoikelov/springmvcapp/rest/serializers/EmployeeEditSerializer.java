package kg.akoikelov.springmvcapp.rest.serializers;

import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.validation.ValueFromList;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Component
public class EmployeeEditSerializer {
    private String userName;
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
    @NotNull
    private String phone;
    private int affiliateId;
    private int cashboxId;
    private String comment;
    private boolean enabled = true;
    @ValueFromList(
            allowedValues = "ROLE_USER",
            message = "Не допустимое значение")
    private String role;

    public EmployeeEditSerializer() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public Employee build(String userName) {
        return new Employee(
                userName,
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
                role);
    }
}
