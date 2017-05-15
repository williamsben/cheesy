package williams.ben

import groovy.transform.ToString
import org.springframework.security.core.GrantedAuthority

/**
 * Created by billiams on 4/27/17.
 */
@ToString(includeNames = true)
class Role implements GrantedAuthority {

    String name

    @Override
    String getAuthority() {
        return this.name
    }
}
