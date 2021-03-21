package kg.akoikelov.springmvcapp.rest.controllers.superadmin;


import io.swagger.annotations.Api;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import kg.akoikelov.springmvcapp.utils.ControllerHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Api(tags = "superadmin", value = "employees")
@RestController
@RequestMapping("/api/superadmin/employees")
public class EmployeesController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public PaginationData<Employee> list(@RequestParam(value = "pagination", defaultValue = "10") String pagination,
                                         @RequestParam(value = "page", defaultValue = "1") String page) {
        int paginationPage = ControllerHelper.parseInt(pagination);
        int pageCount = ControllerHelper.parseInt(page);

        return employeeService.getEmployees(pageCount, paginationPage);

    }
    @GetMapping ("/{id}")
    public Employee getById(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if (employee ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return employee;
    }

}
