package kg.akoikelov.springmvcapp.models;

import java.util.Date;

public class Contract {

  private int id;
  private String identifier;
  private Date date;
  private Date tillDate;
  private int depositPrice;
  private int sum;
  private String type;
  private float percentage;
  private String percentageText;
  private int time;
  private int comission;
  private String paymentDaysOfWeek;
  private String comment;

  private int affiliateId;
  private int customerId;
  private int depositId;
  private int autoDepositId;
  private int cashboxId;
  private int employeeId;
  private int employeeCreateId;
  private int employeeUpdateId;

  private Affiliate affiliate;
  private Customer customer;
  private Deposit deposit;
  private AutoDeposit autoDeposit;
  private CashBox cashBox;
  private Employee employee;
  private Employee employeeCreate;
  private Employee employeeUpdate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Date getTillDate() {
    return tillDate;
  }

  public void setTillDate(Date tillDate) {
    this.tillDate = tillDate;
  }

  public int getDepositPrice() {
    return depositPrice;
  }

  public void setDepositPrice(int depositPrice) {
    this.depositPrice = depositPrice;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public float getPercentage() {
    return percentage;
  }

  public void setPercentage(float percentage) {
    this.percentage = percentage;
  }

  public String getPercentageText() {
    return percentageText;
  }

  public void setPercentageText(String percentageText) {
    this.percentageText = percentageText;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public int getComission() {
    return comission;
  }

  public void setComission(int comission) {
    this.comission = comission;
  }

  public String getPaymentDaysOfWeek() {
    return paymentDaysOfWeek;
  }

  public void setPaymentDaysOfWeek(String paymentDaysOfWeek) {
    this.paymentDaysOfWeek = paymentDaysOfWeek;
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

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public int getDepositId() {
    return depositId;
  }

  public void setDepositId(int depositId) {
    this.depositId = depositId;
  }

  public int getAutoDepositId() {
    return autoDepositId;
  }

  public void setAutoDepositId(int autoDepositId) {
    this.autoDepositId = autoDepositId;
  }

  public int getCashboxId() {
    return cashboxId;
  }

  public void setCashboxId(int cashboxId) {
    this.cashboxId = cashboxId;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public int getEmployeeCreateId() {
    return employeeCreateId;
  }

  public void setEmployeeCreateId(int employeeCreateId) {
    this.employeeCreateId = employeeCreateId;
  }

  public int getEmployeeUpdateId() {
    return employeeUpdateId;
  }

  public void setEmployeeUpdateId(int employeeUpdateId) {
    this.employeeUpdateId = employeeUpdateId;
  }

  public Affiliate getAffiliate() {
    return affiliate;
  }

  public void setAffiliate(Affiliate affiliate) {
    this.affiliate = affiliate;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Deposit getDeposit() {
    return deposit;
  }

  public void setDeposit(Deposit deposit) {
    this.deposit = deposit;
  }

  public AutoDeposit getAutoDeposit() {
    return autoDeposit;
  }

  public void setAutoDeposit(AutoDeposit autoDeposit) {
    this.autoDeposit = autoDeposit;
  }

  public CashBox getCashBox() {
    return cashBox;
  }

  public void setCashBox(CashBox cashBox) {
    this.cashBox = cashBox;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Employee getEmployeeCreate() {
    return employeeCreate;
  }

  public void setEmployeeCreate(Employee employeeCreate) {
    this.employeeCreate = employeeCreate;
  }

  public Employee getEmployeeUpdate() {
    return employeeUpdate;
  }

  public void setEmployeeUpdate(Employee employeeUpdate) {
    this.employeeUpdate = employeeUpdate;
  }
}
