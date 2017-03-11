package williams.ben

import java.util.List

import javax.sql.DataSource

import williams.ben.Cheese

interface CheeseDAO {
	void insert(Cheese cheese);
	Cheese getCheeseById(Integer id);
	List<Cheese> getAll();
}
