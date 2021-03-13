package kg.akoikelov.springmvcapp.jwt;

import kg.akoikelov.springmvcapp.models.Employee;
import kg.akoikelov.springmvcapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    EmployeeService employeeService;

    @Autowired
    public JwtUserDetailsService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public JwtUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employee employee = employeeService.getUserByUserNameForJwt(s);

        return JwtUserDetails.fromEmployeeToCustomUserDetails(employee);
    }
}
