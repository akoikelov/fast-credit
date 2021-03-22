package kg.akoikelov.springmvcapp.rest.controllers.superadmin;


import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.rest.serializers.EmployeeEditSerializer;
import kg.akoikelov.springmvcapp.rest.serializers.EmployeeSerializer;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import kg.akoikelov.springmvcapp.utils.ControllerHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import kg.akoikelov.springmvcapp.utils.ViewsRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Api(tags = "superadmin", value = "employees")
@RestController
@RequestMapping("/api/superadmin/employees")
public class EmployeesController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    @JsonView(ViewsRest.forList.class)
    public PaginationData<Employee> list(@RequestParam(value = "pagination", defaultValue = "10") String pagination,
                                         @RequestParam(value = "page", defaultValue = "1") String page) {
        int paginationPage = ControllerHelper.parseInt(pagination);
        int pageCount = ControllerHelper.parseInt(page);

        return employeeService.getEmployees(pageCount, paginationPage);

    }

    @GetMapping("/{id}")
    @JsonView(ViewsRest.forList.class)
    public Employee getById(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return employee;
    }

    @PostMapping("/new")
    public Employee createEmployee(@Valid @RequestBody EmployeeSerializer employeeSerializer) {
        Employee employee = employeeSerializer.build();
        employeeService.createEmployee(employee);

        return employee;
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable int id, @Valid @RequestBody EmployeeEditSerializer employeeEditSerializer) {
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Employee employee1 = employeeEditSerializer.build(employee.getUserName());
        employee1.setId(id);

        boolean ok = employeeService.updateEmployee(employee1);

        if (!ok) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return employee1;
    }

}
