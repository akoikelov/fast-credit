package kg.akoikelov.springmvcapp.forms;

import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.validation.FieldsValueMatch;
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
@Component
public class ProfileForm {

  private String userName;

  @NotNull @NotBlank private String password;
  @NotNull @NotBlank private String repeatPassword;
  @NotNull @NotBlank private String fullName;

  @Min(value = 0)
  private int salary;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Past
  private Date birthday;

  private String passportId;
  private String address;
  private String phone;
  private String comment;

  public ProfileForm() {}

  public String getRepeatPassword() {
    return repeatPassword;
  }

  public void setRepeatPassword(String repeatPassword) {
    this.repeatPassword = repeatPassword;
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

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
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



  public ProfileForm(Employee employee) {
    this.userName = employee.getUserName();
    this.fullName = employee.getFullName();
    this.birthday = employee.getBirthday();
    this.passportId = employee.getPassportId();
    this.address = employee.getAddress();
    this.phone = employee.getPhone();
    this.comment = employee.getComment();
  }

  public Employee buildProfile() {
    return new Employee(
        userName, password, fullName, birthday, passportId, address, phone, comment);
  }
}
