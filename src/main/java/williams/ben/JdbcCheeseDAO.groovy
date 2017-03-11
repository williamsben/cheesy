package williams.ben;

import groovy.sql.Sql

import java.sql.Connection

import javax.naming.Context
import javax.naming.InitialContext
import javax.sql.DataSource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
public class JdbcCheeseDAO implements CheeseDAO{

	@Autowired
	public DataSource dataSource

	Sql sqlInstance(){
		new Sql(dataSource.getConnection())
	}

	@Override
	void insert(Cheese cheese) {
		Sql sql = sqlInstance()
		sql.execute("insert into cheeses (name, taste) values (${cheese.getName()}, ${cheese.getTaste()})")
		sql.connection.close()
	}

	@Override
	Cheese getCheeseById(Integer id) {
		Sql sql = sqlInstance()
		println sql.connection.hashCode()
		Cheese cheese = new Cheese();
		try{
			sql.eachRow("select * from cheeses where id=${id}") { row ->
				cheese.name = row.name
				cheese.id = row.id
				cheese.taste = row.taste
			}
		}catch(Exception e){
			println e
		}
		sql.connection.close()
		return cheese;
	}

	@Override
	public List<Cheese> getAll() {
		Sql sql = sqlInstance()
		List<Cheese> cheeses = new ArrayList<>()
			sql.eachRow("select * from cheeses") { row ->
			Cheese cheese = new Cheese()
			cheese.name = row.name
			cheese.id = row.id
			cheese.taste = row.taste
			cheeses.add(cheese)
		}
		sql.connection.close()
		return cheeses;
	}

}
