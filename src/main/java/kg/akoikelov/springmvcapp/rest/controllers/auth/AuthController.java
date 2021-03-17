package kg.akoikelov.springmvcapp.rest.controllers.auth;

import io.swagger.annotations.Api;
import kg.akoikelov.springmvcapp.jwt.JwtProvider;
import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.rest.serializers.LoginSerializer;
import kg.akoikelov.springmvcapp.rest.serializers.TokenSerializer;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
@Api(value = "hren dly autorizathii", tags = "login")
public class AuthController {

    EmployeeService employeeService;
    JwtProvider jwtProvider;

    @Autowired
    public AuthController(EmployeeService employeeService, JwtProvider jwtProvider) {
        this.employeeService = employeeService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/login")
    public TokenSerializer login(@RequestBody LoginSerializer loginSerializer) {
        Employee employee =
                employeeService.getUserByUserNameAndPassword(
                        loginSerializer.getUsername(), loginSerializer.getPassword());

        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
        }

        String token = jwtProvider.generateToken(employee.getUserName());

        return new TokenSerializer(token);
    }
}
