package kg.akoikelov.springmvcapp.forms;

import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.models.CashBox;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.validation.ValueFromList;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.*;

@Component
public class EmployeeEditForm {
  private String userName;

  public Map<Integer, String> affiliates = new HashMap<>();
  public Map<Integer, String> cashboxes = new HashMap<>();
  public Map<String, String> positions =
      Map.of(
          "it", "Админ", "director", "Директор", "manager", "Поломойка", "polomoika", "Секретарша");

  @NotNull @NotBlank private String fullName;

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
  @NotNull private String phone;
  private Affiliate affiliate;
  private int affiliateId;
  private CashBox cashBox;
  private int cashboxId;
  private String comment;
  private boolean enabled = true;

  public String getOldRole() {
    return oldRole;
  }

  public void setOldRole(String oldRole) {
    this.oldRole = oldRole;
  }

  private String oldRole;

  public Map<String, String> getRoles() {
    return roles;
  }

  public Map<String, String> roles;

  {
    roles = new TreeMap<>();
    roles.put("", "Выберите роль");
    roles.put("ROLE_USER", "Сотрудник");
    roles.put("ROLE_ADMIN", "ADMIN");
    roles.put("ROLE_SUPERADMIN", "SUPERADMIN");
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  private String role;

  public EmployeeEditForm() {}

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

  public EmployeeEditForm(Employee employee) {
    this.userName = employee.getUserName();
    this.fullName = employee.getFullName();
    this.position = employee.getPosition();
    this.salary = employee.getSalary();
    this.isWorking = employee.isWorking();
    this.birthday = employee.getBirthday();
    this.passportId = employee.getPassportId();
    this.address = employee.getAddress();
    this.phone = employee.getPhone();
    this.affiliateId = employee.getAffiliateId();
    this.cashboxId = employee.getCashboxId();
    this.comment = employee.getComment();
    this.oldRole=employee.getRole();
  }






  public  boolean roleChanged(){
    return !this.oldRole.equals(this.role);
  }
}
