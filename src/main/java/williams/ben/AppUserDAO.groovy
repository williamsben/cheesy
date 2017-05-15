package williams.ben

import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

import javax.sql.DataSource

/**
 * Created by billiams on 4/27/17.
 */
@Component
class AppUserDAO {

    @Autowired
    public DataSource dataSource

    Sql sqlInstance(){
        new Sql(dataSource.getConnection())
    }

    User loadUserByUsername(String username){
        Sql sql = sqlInstance()
        User user = new User();
        try{
            sql.eachRow("select username,password,enabled from users where username=${username}") { row ->
                user.username = row.username
                user.password = row.password
                user.enabled = row.enabled
            }
            sql.eachRow("select username, role from user_roles where username=${username}") { row ->
                Role role = new Role([name: row.role])
                user.addRole(role)
            }
        }catch(Exception e){
            println e
            return null
        }
        sql.connection.close()
        return user;
    }
}
