package williams.ben

import groovy.transform.ToString
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * Created by billiams on 4/27/17.
 */
@ToString(includeNames = true)
class User implements UserDetails {

    String username
    String password
    Boolean enabled
    List authorities

    User() {
        authorities = new ArrayList()
    }

    @Override
    Collection getAuthorities() {
        return authorities
    }

    void addRole(Role role){
        authorities.add(role)
    }

    @Override
    String getPassword() {
        return password
    }

    @Override
    String getUsername() {
        return username
    }

    @Override
    boolean isAccountNonExpired() {
        return false
    }

    @Override
    boolean isAccountNonLocked() {
        return false
    }

    @Override
    boolean isCredentialsNonExpired() {
        return false
    }

    @Override
    boolean isEnabled() {
        return enabled
    }
}
