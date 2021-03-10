package kg.akoikelov.springmvcapp.security;

import com.zaxxer.hikari.HikariDataSource;
import kg.akoikelov.springmvcapp.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    HikariDataSource hikariDataSource;

    @Autowired
    public AppSecurityConfig(@Qualifier("hikariapp") @Lazy HikariDataSource hikariDataSource) {
        this.hikariDataSource = hikariDataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(hikariDataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from employees where username =?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/*")
                .hasAnyRole(Employee.USER, Employee.SUPERADMIN, Employee.ADMIN)
                .antMatchers("/superadmin/**")
                .hasRole(Employee.SUPERADMIN)
                .antMatchers("/admin/**")
                .hasRole(Employee.ADMIN)
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
