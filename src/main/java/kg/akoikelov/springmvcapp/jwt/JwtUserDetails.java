package kg.akoikelov.springmvcapp.jwt;

import kg.akoikelov.springmvcapp.models.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class JwtUserDetails implements UserDetails {

    private String username;
    private String password;
    private boolean enabled;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static JwtUserDetails fromEmployeeToCustomUserDetails(Employee employee) {
        JwtUserDetails user = new JwtUserDetails();
        user.username = employee.getUserName();
        user.password = employee.getPassword();
        user.enabled = employee.isEnabled();
        user.grantedAuthorities =
                Collections.singletonList(new SimpleGrantedAuthority(employee.getRole()));
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
