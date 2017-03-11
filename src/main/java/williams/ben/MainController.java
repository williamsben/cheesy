package williams.ben;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import williams.ben.Cheese;
import williams.ben.JdbcCheeseDAO;

@Controller
@RequestMapping("/")
public class MainController {

  @Autowired
	JdbcCheeseDAO cheeseDAO;

	@RequestMapping(method=RequestMethod.GET)
	public String home(){
		return "index";
	}

  @RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> addCheese(Cheese cheese){
		cheeseDAO.insert(cheese);
		return ResponseEntity.ok().body(null);
	}

  @ResponseBody
  @RequestMapping(value="/cheeses")
  public Map<String, List<Cheese>> getCheeses(){
      Map<String, List<Cheese>> result = new HashMap<>();
      result.put("data", cheeseDAO.getAll());
    return result;
  }
}
