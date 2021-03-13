package kg.akoikelov.springmvcapp.security;

import com.zaxxer.hikari.HikariDataSource;
import kg.akoikelov.springmvcapp.jwt.JwtFilter;
import kg.akoikelov.springmvcapp.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class AppSecurityConfig {

    HikariDataSource hikariDataSource;
    JwtFilter jwtFilter;

    @Autowired
    public AppSecurityConfig(
            @Qualifier("hikariapp") @Lazy HikariDataSource hikariDataSource, JwtFilter jwtFilter) {
        this.hikariDataSource = hikariDataSource;
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(2)
    public static class SessionConfig extends WebSecurityConfigurerAdapter {

        HikariDataSource hikariDataSource;
        JwtFilter jwtFilter;

        @Autowired
        public SessionConfig(
                @Qualifier("hikariapp") @Lazy HikariDataSource hikariDataSource, JwtFilter jwtFilter) {
            this.hikariDataSource = hikariDataSource;
            this.jwtFilter = jwtFilter;
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
    }

    @Configuration
    @Order(1)
    public static class RestApiConfig extends WebSecurityConfigurerAdapter {

        HikariDataSource hikariDataSource;
        JwtFilter jwtFilter;

        @Autowired
        public RestApiConfig(
                @Qualifier("hikariapp") @Lazy HikariDataSource hikariDataSource, JwtFilter jwtFilter) {
            this.hikariDataSource = hikariDataSource;
            this.jwtFilter = jwtFilter;
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
            http.csrf()
                    .disable()
                    .antMatcher("/api/**")
                    .authorizeRequests()
                    .antMatchers("/api/login")
                    .permitAll()
                    .and()
                    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        }
    }
}
