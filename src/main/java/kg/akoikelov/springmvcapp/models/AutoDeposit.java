package kg.akoikelov.springmvcapp.models;

public class AutoDeposit {

    private int id;
    private String proxy;
    private String model;
    private String idNumber;
    private String type;
    private String yearColor;
    private String modelEngine;
    private String carcase;
    private String certificate;
    private String govNumber;
    private String comment;
    private boolean isArrested;
    private String ownership;
    private int employeeCreateId;
    private int employeeUpdateId;
    private int customerId;
    private Employee employeeCreate;
    private Employee employeeUpdate;
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYearColor() {
        return yearColor;
    }

    public void setYearColor(String yearColor) {
        this.yearColor = yearColor;
    }

    public String getModelEngine() {
        return modelEngine;
    }

    public void setModelEngine(String modelEngine) {
        this.modelEngine = modelEngine;
    }

    public String getCarcase() {
        return carcase;
    }

    public void setCarcase(String carcase) {
        this.carcase = carcase;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getGovNumber() {
        return govNumber;
    }

    public void setGovNumber(String govNumber) {
        this.govNumber = govNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isArrested() {
        return isArrested;
    }

    public void setArrested(boolean arrested) {
        isArrested = arrested;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
