package kg.akoikelov.springmvcapp.models;

import java.util.Date;

public class Employee {
    private int id;
    private String userName;
    private String password;
    private String fullName;
    private String position;
    private int salary;
    private boolean isWorking;
    private Date birthday;
    private String passportId;
    private String address;
    private String phone;
    private Affiliate affiliate;
    private CashBox cashBox;
    private String comment;
    private String role;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
    }

    public void setCashBox(CashBox cashBox) {
        this.cashBox = cashBox;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPassportId() {
        return passportId;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Affiliate getAffiliate() {
        return affiliate;
    }

    public CashBox getCashBox() {
        return cashBox;
    }

    public String getComment() {
        return comment;
    }

    public String getRole() {
        return role;
    }
}
