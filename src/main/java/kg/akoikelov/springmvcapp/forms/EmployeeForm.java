package kg.akoikelov.springmvcapp.forms;

import kg.akoikelov.springmvcapp.dao.EmployeeDAO;
import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.models.CashBox;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.validation.FieldsValueMatch;
import kg.akoikelov.springmvcapp.validation.Unique;
import kg.akoikelov.springmvcapp.validation.ValueFromList;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.*;

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
public class EmployeeForm {

    public Map<Integer, String> affiliates = new HashMap<>();
    public Map<Integer, String> cashboxes = new HashMap<>();
    public Map<String, String> positions =
            Map.of(
                    "it", "Админ", "director", "Директор", "manager", "Поломойка", "polomoika", "Секретарша");
    public Map<String, String> roles;
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
    private Affiliate affiliate;
    private int affiliateId;
    private CashBox cashBox;
    private int cashboxId;
    private String comment;
    private String role;
    private boolean enabled = true;

    {
        roles = new TreeMap<>();
        roles.put("", "Выберите роль");
        roles.put("ROLE_USER", "Сотрудник");
        roles.put("ROLE_ADMIN", "ADMIN");
        roles.put("ROLE_SUPERADMIN", "SUPERADMIN");
    }

    public EmployeeForm() {
    }

    public Map<String, String> getRoles() {
        return roles;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Map<Integer, String> getAffiliates() {
        return affiliates;
    }

    public void setAffiliates(List<Affiliate> affiliatesList) {
        for (Affiliate affiliate : affiliatesList) {
            affiliates.put(affiliate.getId(), affiliate.getTitle());
        }
    }

    public Map<String, String> getPositions() {
        return positions;
    }

    public void setPositions(Map<String, String> positions) {
        this.positions = positions;
    }

    public Map<Integer, String> getCashboxes() {
        return cashboxes;
    }

    public void setCashboxes(List<CashBox> cashboxesList) {
        for (CashBox cashBox : cashboxesList) {
            cashboxes.put(cashBox.getId(), cashBox.getTitle());
        }
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

    public Affiliate getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
    }

    public CashBox getCashBox() {
        return cashBox;
    }

    public void setCashBox(CashBox cashBox) {
        this.cashBox = cashBox;
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
