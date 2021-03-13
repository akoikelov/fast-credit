package kg.akoikelov.springmvcapp.forms;

import kg.akoikelov.springmvcapp.models.Deposit;
import kg.akoikelov.springmvcapp.models.Employee;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DepositForm {

    private int id;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @Min(value = 0, message = "Поле не должно быть пустым")
    private int price;
    @NotNull
    @NotBlank
    private String notes;
    private String comment;
    private int customerId;
    private int employeeCreateId;
    private int employeeUpdateId;

    private Employee employeeCreate;
    private Employee employeeUpdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public Deposit build(Employee employee) {
        return new Deposit(title, price, notes, comment, customerId, employee);
    }

    public DepositForm(Deposit deposit) {
        this.id = deposit.getId();
        this.title = deposit.getTitle();
        this.price = deposit.getPrice();
        this.notes = deposit.getNotes();
        this.comment = deposit.getComment();
        this.customerId = deposit.getCustomerId();

    }

    public DepositForm() {
    }
}
