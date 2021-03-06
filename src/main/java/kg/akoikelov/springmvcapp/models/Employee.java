package kg.akoikelov.springmvcapp.models;

import com.fasterxml.jackson.annotation.JsonView;
import kg.akoikelov.springmvcapp.utils.ViewsRest;

import java.util.Date;

public class Employee {
    public static final String USER = "USER";
    public static final String SUPERADMIN = "SUPERADMIN";
    public static final String ADMIN = "ADMIN";

    private int id;
    @JsonView(ViewsRest.forList.class)
    private String userName;
    private String password;
    @JsonView(ViewsRest.forList.class)
    private String fullName;
    @JsonView(ViewsRest.forList.class)
    private String position;
    @JsonView(ViewsRest.forList.class)
    private int salary;
    private boolean isWorking;
    @JsonView(ViewsRest.forList.class)
    private Date birthday;
    private String passportId;
    @JsonView(ViewsRest.forList.class)
    private String address;
    private String phone;
    private Affiliate affiliate;
    private int affiliateId;
    private CashBox cashBox;
    private int cashboxId;
    private String comment;
    private String role;
    private boolean enabled;

    public Employee(
            String userName,
            String password,
            String fullName,
            String position,
            int salary,
            boolean isWorking,
            Date birthday,
            String passportId,
            String address,
            String phone,
            int affiliateId,
            int cashboxId,
            String comment,
            boolean enabled,
            String role) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
        this.isWorking = isWorking;
        this.birthday = birthday;
        this.passportId = passportId;
        this.address = address;
        this.phone = phone;
        this.affiliateId = affiliateId;
        this.cashboxId = cashboxId;
        this.comment = comment;
        this.enabled = enabled;
        this.role = role;
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee() {
    }

    public Employee(
            String userName,
            String fullName,
            String position,
            int salary,
            boolean isWorking,
            Date birthday,
            String passportId,
            String address,
            String phone,
            int affiliateId,
            int cashboxId,
            String comment,
            String role) {
        this.userName = userName;
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
        this.isWorking = isWorking;
        this.birthday = birthday;
        this.passportId = passportId;
        this.address = address;
        this.phone = phone;
        this.affiliateId = affiliateId;
        this.cashboxId = cashboxId;
        this.comment = comment;
        this.role = role;
    }

    public Employee(
            String userName,
            String password,
            String fullName,
            Date birthday,
            String passportId,
            String address,
            String phone,
            String comment) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.birthday = birthday;
        this.passportId = passportId;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}
