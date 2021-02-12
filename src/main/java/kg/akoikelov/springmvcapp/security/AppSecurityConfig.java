package kg.akoikelov.springmvcapp.security;

import com.zaxxer.hikari.HikariDataSource;
import kg.akoikelov.springmvcapp.models.Employee;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

  @Qualifier("hikariapp")
  @Autowired
  HikariDataSource hikariDataSource;

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
        .antMatchers("/")
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
}
