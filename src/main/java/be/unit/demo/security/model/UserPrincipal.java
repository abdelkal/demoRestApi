package be.unit.demo.security.model;

import be.unit.demo.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private User user;

    public UserPrincipal(User user){
        this.user = user;
    }

    public UserPrincipal() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        //Extract list of permissions
        for(String permission: this.user.getPermissionList()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission);
            authorities.add(grantedAuthority);
        }

        //Extract list of roles
        for(String role: this.user.getRoleList()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role);
            authorities.add(grantedAuthority);
        }

        return authorities;

    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.getIsActive() == 1;
    }
}
