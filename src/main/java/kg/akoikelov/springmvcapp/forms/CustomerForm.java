package kg.akoikelov.springmvcapp.forms;

import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.models.Customer;
import kg.akoikelov.springmvcapp.models.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class CustomerForm {

    public Map<String, String> marital = new TreeMap<>();
    private Map<String, String> workPlaces = new TreeMap<>();
    private int id;
    @NotNull
    @NotBlank
    private String fullName;

    @NotNull
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotNull
    @NotBlank
    private String passportId;
    @NotNull
    @NotBlank
    private String address;

    @Pattern(regexp = "[0-9]{3}?\\-[0-9]{9}", message = "формат номера не совпадает")
    @NotNull
    @NotBlank
    private String phone;

    @NotNull
    @NotBlank
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
    @NotNull
    private int numberOfChildren;
    private String actualAddress;
    private String relativesPhones;
    @NotNull
    private int daysSalaryLevel;
    private String otherIncome;
    private String monthlyPayments;
    private String ownership;
    private String receivedCreditBefore;

    private Date dateOfQuestioning = new Date();

    @NotNull
    private int affiliateId;
    private Affiliate affiliate;
    private int balance;
    private boolean isArrested;
    @NotNull
    private int employeeCreateId;
    private int employeeUpdateId;
    private String color;
    private String regularComment;
    private Date disableFineTillDate;

    {
        marital.put(Customer.UNMARRIED, "Холост/Не замужем");
        marital.put(Customer.MARRIED, "Женат/Замужем");
        marital.put(Customer.DIVORCED, "Разведен/Разведена");
        marital.put(Customer.WIDOWER, "Вдовец/Вдова");
    }

    {
        workPlaces.put("Парикмахерская", "Парикмахерская");
        workPlaces.put("Банкир", "Банкир");
        workPlaces.put("Миллиардер", "Милиардер");
        workPlaces.put("Жопник", "Жопник");
    }

    public CustomerForm() {
    }

    public CustomerForm(Customer customer) {
        this.id = customer.getId();
        this.fullName = customer.getFullName();
        this.birthday = customer.getBirthday();
        this.passportId = customer.getPassportId();
        this.address = customer.getAddress();
        this.phone = customer.getPhone();
        this.smsPhone = customer.getSmsPhone();
        this.fineEnabled = customer.isFineEnabled();
        this.blackList = customer.isBlackList();
        this.comment = customer.getComment();
        this.note = customer.getNote();
        this.weeksNote = customer.getWeeksNote();
        this.taxiCompany = customer.getTaxiCompany();
        this.bortNumber = customer.getBortNumber();
        this.shift = customer.getShift();
        this.placeOfBirth = customer.getPlaceOfBirth();
        this.maritalStatus = customer.getMaritalStatus();
        this.partnerFullName = customer.getPartnerFullName();
        this.partnerWorkplace = customer.getPartnerWorkplace();
        this.partnerPhone = customer.getPartnerPhone();
        this.brotherPhone = customer.getBrotherPhone();
        this.sisterPhone = customer.getSisterPhone();
        this.motherPhone = customer.getMotherPhone();
        this.fatherPhone = customer.getFatherPhone();
        this.roommatePhone = customer.getRoommatePhone();
        this.motherFullName = customer.getMotherFullName();
        this.fatherFullName = customer.getFatherFullName();
        this.sisterFullName = customer.getSisterFullName();
        this.brotherFullName = customer.getBrotherFullName();
        this.parentWorkPlace = customer.getPartnerWorkplace();
        this.workPlace = customer.getWorkPlace();
        this.workPlaceMore = customer.getParentWorkPlace();
        this.numberOfChildren = customer.getNumberOfChildren();
        this.actualAddress = customer.getActualAddress();
        this.relativesPhones = customer.getRelativesPhones();
        this.daysSalaryLevel = customer.getDaysSalaryLevel();
        this.otherIncome = customer.getOtherIncome();
        this.monthlyPayments = customer.getMonthlyPayments();
        this.ownership = customer.getOwnership();
        this.receivedCreditBefore = customer.getReceivedCreditBefore();
        this.dateOfQuestioning = customer.getDateOfQuestioning();

    }

    public int getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(int affiliateId) {
        this.affiliateId = affiliateId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, String> getMarital() {
        return marital;
    }

    public void setMarital(Map<String, String> marital) {
        this.marital = marital;
    }

    public Map<String, String> getWorkPlaces() {
        return workPlaces;
    }

    public void setWorkPlaces(Map<String, String> workPlaces) {
        this.workPlaces = workPlaces;
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

    public boolean getIsArrested() {
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

    public Customer build(Employee employee) {
        return new Customer(
                fullName,
                birthday,
                passportId,
                address,
                phone,
                smsPhone,
                fineEnabled,
                blackList,
                comment,
                note,
                weeksNote,
                taxiCompany,
                bortNumber,
                shift,
                placeOfBirth,
                maritalStatus,
                partnerFullName,
                parentWorkPlace,
                partnerPhone,
                brotherPhone,
                sisterPhone,
                motherPhone,
                fatherPhone,
                roommatePhone,
                motherFullName,
                fatherFullName,
                sisterFullName,
                brotherFullName,
                parentWorkPlace,
                workPlace,
                workPlaceMore,
                numberOfChildren,
                actualAddress,
                relativesPhones,
                daysSalaryLevel,
                otherIncome,
                monthlyPayments,
                ownership,
                receivedCreditBefore,
                dateOfQuestioning,
                affiliate,
                balance,
                isArrested,
                employeeCreateId,
                employeeUpdateId,
                color,
                regularComment,
                disableFineTillDate,
                employee);
    }

}
