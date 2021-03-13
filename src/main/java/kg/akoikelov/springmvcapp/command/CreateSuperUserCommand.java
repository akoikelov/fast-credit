package kg.akoikelov.springmvcapp.command;

import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateSuperUserCommand implements Command {

    EmployeeService employeeService;

    @Autowired
    public CreateSuperUserCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        this.showHeader();

        System.out.println("Username: ");
        String username = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();

        System.out.println("Affiliate ID: ");
        int affiliateId = Integer.parseInt(scanner.nextLine());

        System.out.println("Cashbox ID: ");
        int cashboxId = Integer.parseInt(scanner.nextLine());

        Employee employee = new Employee();
        employee.setUserName(username);
        employee.setPassword(password);
        employee.setFullName(username);
        employee.setAddress("");
        employee.setRole("ROLE_" + Employee.SUPERADMIN);
        employee.setAffiliateId(affiliateId);
        employee.setCashboxId(cashboxId);
        employee.setEnabled(true);

        employeeService.createEmployee(employee);

        System.out.println("User created successfully");
    }

    @Override
    public String getName() {
        return "createsuperuser";
    }
}
