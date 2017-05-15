package williams.ben

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

/**
 * Created by billiams on 4/27/17.
 */
@Component
class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserDAO userDao;

    @Override
    User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.loadUserByUsername(username)
    }

}
