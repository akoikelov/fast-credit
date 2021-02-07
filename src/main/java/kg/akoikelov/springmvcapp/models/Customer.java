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
    /**
     * TODO: Add employeeCreate, employeeEdit fields
     */
    private boolean isArrested;
    private String color;
    private String regularComment;
    private Date disableFineTillDate;

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public void setSmsPhone(String smsPhone) {
        this.smsPhone = smsPhone;
    }

    public void setFineEnabled(boolean fineEnabled) {
        this.fineEnabled = fineEnabled;
    }

    public void setBlackList(boolean blackList) {
        this.blackList = blackList;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setWeeksNote(String weeksNote) {
        this.weeksNote = weeksNote;
    }

    public void setTaxiCompany(String taxiCompany) {
        this.taxiCompany = taxiCompany;
    }

    public void setBortNumber(String bortNumber) {
        this.bortNumber = bortNumber;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setPartnerFullName(String partnerFullName) {
        this.partnerFullName = partnerFullName;
    }

    public void setPartnerWorkplace(String partnerWorkplace) {
        this.partnerWorkplace = partnerWorkplace;
    }

    public void setPartnerPhone(String partnerPhone) {
        this.partnerPhone = partnerPhone;
    }

    public void setBrotherPhone(String brotherPhone) {
        this.brotherPhone = brotherPhone;
    }

    public void setSisterPhone(String sisterPhone) {
        this.sisterPhone = sisterPhone;
    }

    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    public void setRoommatePhone(String roommatePhone) {
        this.roommatePhone = roommatePhone;
    }

    public void setMotherFullName(String motherFullName) {
        this.motherFullName = motherFullName;
    }

    public void setFatherFullName(String fatherFullName) {
        this.fatherFullName = fatherFullName;
    }

    public void setSisterFullName(String sisterFullName) {
        this.sisterFullName = sisterFullName;
    }

    public void setBrotherFullName(String brotherFullName) {
        this.brotherFullName = brotherFullName;
    }

    public void setParentWorkPlace(String parentWorkPlace) {
        this.parentWorkPlace = parentWorkPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public void setWorkPlaceMore(String workPlaceMore) {
        this.workPlaceMore = workPlaceMore;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public void setActualAddress(String actualAddress) {
        this.actualAddress = actualAddress;
    }

    public void setRelativesPhones(String relativesPhones) {
        this.relativesPhones = relativesPhones;
    }

    public void setDaysSalaryLevel(int daysSalaryLevel) {
        this.daysSalaryLevel = daysSalaryLevel;
    }

    public void setOtherIncome(String otherIncome) {
        this.otherIncome = otherIncome;
    }

    public void setMonthlyPayments(String monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public void setReceivedCreditBefore(String receivedCreditBefore) {
        this.receivedCreditBefore = receivedCreditBefore;
    }

    public void setDateOfQuestioning(Date dateOfQuestioning) {
        this.dateOfQuestioning = dateOfQuestioning;
    }

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setArrested(boolean arrested) {
        isArrested = arrested;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRegularComment(String regularComment) {
        this.regularComment = regularComment;
    }

    public void setDisableFineTillDate(Date disableFineTillDate) {
        this.disableFineTillDate = disableFineTillDate;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
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

    public String getSmsPhone() {
        return smsPhone;
    }

    public boolean isFineEnabled() {
        return fineEnabled;
    }

    public boolean isBlackList() {
        return blackList;
    }

    public String getComment() {
        return comment;
    }

    public String getNote() {
        return note;
    }

    public String getWeeksNote() {
        return weeksNote;
    }

    public String getTaxiCompany() {
        return taxiCompany;
    }

    public String getBortNumber() {
        return bortNumber;
    }

    public String getShift() {
        return shift;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getPartnerFullName() {
        return partnerFullName;
    }

    public String getPartnerWorkplace() {
        return partnerWorkplace;
    }

    public String getPartnerPhone() {
        return partnerPhone;
    }

    public String getBrotherPhone() {
        return brotherPhone;
    }

    public String getSisterPhone() {
        return sisterPhone;
    }

    public String getMotherPhone() {
        return motherPhone;
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public String getRoommatePhone() {
        return roommatePhone;
    }

    public String getMotherFullName() {
        return motherFullName;
    }

    public String getFatherFullName() {
        return fatherFullName;
    }

    public String getSisterFullName() {
        return sisterFullName;
    }

    public String getBrotherFullName() {
        return brotherFullName;
    }

    public String getParentWorkPlace() {
        return parentWorkPlace;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public String getWorkPlaceMore() {
        return workPlaceMore;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public String getActualAddress() {
        return actualAddress;
    }

    public String getRelativesPhones() {
        return relativesPhones;
    }

    public int getDaysSalaryLevel() {
        return daysSalaryLevel;
    }

    public String getOtherIncome() {
        return otherIncome;
    }

    public String getMonthlyPayments() {
        return monthlyPayments;
    }

    public String getOwnership() {
        return ownership;
    }

    public String getReceivedCreditBefore() {
        return receivedCreditBefore;
    }

    public Date getDateOfQuestioning() {
        return dateOfQuestioning;
    }

    public Affiliate getAffiliate() {
        return affiliate;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isArrested() {
        return isArrested;
    }

    public String getColor() {
        return color;
    }

    public String getRegularComment() {
        return regularComment;
    }

    public Date getDisableFineTillDate() {
        return disableFineTillDate;
    }

}
