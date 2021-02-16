package kg.akoikelov.springmvcapp.models;

import java.util.Date;

public class Customer {

  private int id;
  private String fullName;
  private Date birthday;
  private String passportId;
  private String address;
  private String phone;
  private String smsPhone;
  private boolean fineEnabled;
  private boolean blackList;
  private String comment;
  private String note;
  private String weeksNote;
  private String taxiCompany;
  private String bortNumber;
  private String shift;
  private String placeOfBirth;
  private String maritalStatus;
  private String partnerFullName;
  private String partnerWorkplace;
  private String partnerPhone;
  private String brotherPhone;
  private String sisterPhone;
  private String motherPhone;
  private String fatherPhone;
  private String roommatePhone;
  private String motherFullName;
  private String fatherFullName;
  private String sisterFullName;
  private String brotherFullName;
  private String parentWorkPlace;
  private String workPlace;
  private String workPlaceMore;
  private int numberOfChildren;
  private String actualAddress;
  private String relativesPhones;
  private int daysSalaryLevel;
  private String otherIncome;
  private String monthlyPayments;
  private String ownership;
  private String receivedCreditBefore;
  private Date dateOfQuestioning;
  private Affiliate affiliate;
  private int balance;
  /** TODO: Add employeeCreate, employeeEdit fields */
  private boolean isArrested;

  private String color;
  private String regularComment;
  private Date disableFineTillDate;

  public int getId() {
    return id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
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

  public String getSmsPhone() {
    return smsPhone;
  }

  public void setSmsPhone(String smsPhone) {
    this.smsPhone = smsPhone;
  }

  public boolean isFineEnabled() {
    return fineEnabled;
  }

  public void setFineEnabled(boolean fineEnabled) {
    this.fineEnabled = fineEnabled;
  }

  public boolean isBlackList() {
    return blackList;
  }

  public void setBlackList(boolean blackList) {
    this.blackList = blackList;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getWeeksNote() {
    return weeksNote;
  }

  public void setWeeksNote(String weeksNote) {
    this.weeksNote = weeksNote;
  }

  public String getTaxiCompany() {
    return taxiCompany;
  }

  public void setTaxiCompany(String taxiCompany) {
    this.taxiCompany = taxiCompany;
  }

  public String getBortNumber() {
    return bortNumber;
  }

  public void setBortNumber(String bortNumber) {
    this.bortNumber = bortNumber;
  }

  public String getShift() {
    return shift;
  }

  public void setShift(String shift) {
    this.shift = shift;
  }

  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  public void setPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public String getPartnerFullName() {
    return partnerFullName;
  }

  public void setPartnerFullName(String partnerFullName) {
    this.partnerFullName = partnerFullName;
  }

  public String getPartnerWorkplace() {
    return partnerWorkplace;
  }

  public void setPartnerWorkplace(String partnerWorkplace) {
    this.partnerWorkplace = partnerWorkplace;
  }

  public String getPartnerPhone() {
    return partnerPhone;
  }

  public void setPartnerPhone(String partnerPhone) {
    this.partnerPhone = partnerPhone;
  }

  public String getBrotherPhone() {
    return brotherPhone;
  }

  public void setBrotherPhone(String brotherPhone) {
    this.brotherPhone = brotherPhone;
  }

  public String getSisterPhone() {
    return sisterPhone;
  }

  public void setSisterPhone(String sisterPhone) {
    this.sisterPhone = sisterPhone;
  }

  public String getMotherPhone() {
    return motherPhone;
  }

  public void setMotherPhone(String motherPhone) {
    this.motherPhone = motherPhone;
  }

  public String getFatherPhone() {
    return fatherPhone;
  }

  public void setFatherPhone(String fatherPhone) {
    this.fatherPhone = fatherPhone;
  }

  public String getRoommatePhone() {
    return roommatePhone;
  }

  public void setRoommatePhone(String roommatePhone) {
    this.roommatePhone = roommatePhone;
  }

  public String getMotherFullName() {
    return motherFullName;
  }

  public void setMotherFullName(String motherFullName) {
    this.motherFullName = motherFullName;
  }

  public String getFatherFullName() {
    return fatherFullName;
  }

  public void setFatherFullName(String fatherFullName) {
    this.fatherFullName = fatherFullName;
  }

  public String getSisterFullName() {
    return sisterFullName;
  }

  public void setSisterFullName(String sisterFullName) {
    this.sisterFullName = sisterFullName;
  }

  public String getBrotherFullName() {
    return brotherFullName;
  }

  public void setBrotherFullName(String brotherFullName) {
    this.brotherFullName = brotherFullName;
  }

  public String getParentWorkPlace() {
    return parentWorkPlace;
  }

  public void setParentWorkPlace(String parentWorkPlace) {
    this.parentWorkPlace = parentWorkPlace;
  }

  public String getWorkPlace() {
    return workPlace;
  }

  public void setWorkPlace(String workPlace) {
    this.workPlace = workPlace;
  }

  public String getWorkPlaceMore() {
    return workPlaceMore;
  }

  public void setWorkPlaceMore(String workPlaceMore) {
    this.workPlaceMore = workPlaceMore;
  }

  public int getNumberOfChildren() {
    return numberOfChildren;
  }

  public void setNumberOfChildren(int numberOfChildren) {
    this.numberOfChildren = numberOfChildren;
  }

  public String getActualAddress() {
    return actualAddress;
  }

  public void setActualAddress(String actualAddress) {
    this.actualAddress = actualAddress;
  }

  public String getRelativesPhones() {
    return relativesPhones;
  }

  public void setRelativesPhones(String relativesPhones) {
    this.relativesPhones = relativesPhones;
  }

  public int getDaysSalaryLevel() {
    return daysSalaryLevel;
  }

  public void setDaysSalaryLevel(int daysSalaryLevel) {
    this.daysSalaryLevel = daysSalaryLevel;
  }

  public String getOtherIncome() {
    return otherIncome;
  }

  public void setOtherIncome(String otherIncome) {
    this.otherIncome = otherIncome;
  }

  public String getMonthlyPayments() {
    return monthlyPayments;
  }

  public void setMonthlyPayments(String monthlyPayments) {
    this.monthlyPayments = monthlyPayments;
  }

  public String getOwnership() {
    return ownership;
  }

  public void setOwnership(String ownership) {
    this.ownership = ownership;
  }

  public String getReceivedCreditBefore() {
    return receivedCreditBefore;
  }

  public void setReceivedCreditBefore(String receivedCreditBefore) {
    this.receivedCreditBefore = receivedCreditBefore;
  }

  public Date getDateOfQuestioning() {
    return dateOfQuestioning;
  }

  public void setDateOfQuestioning(Date dateOfQuestioning) {
    this.dateOfQuestioning = dateOfQuestioning;
  }

  public Affiliate getAffiliate() {
    return affiliate;
  }

  public void setAffiliate(Affiliate affiliate) {
    this.affiliate = affiliate;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public boolean isArrested() {
    return isArrested;
  }

  public void setArrested(boolean arrested) {
    isArrested = arrested;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getRegularComment() {
    return regularComment;
  }

  public void setRegularComment(String regularComment) {
    this.regularComment = regularComment;
  }

  public Date getDisableFineTillDate() {
    return disableFineTillDate;
  }

  public void setDisableFineTillDate(Date disableFineTillDate) {
    this.disableFineTillDate = disableFineTillDate;
  }
}
