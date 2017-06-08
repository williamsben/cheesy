package williams.ben;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    Validator validator;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addCheese(Cheese cheese) {
        Map result = validator.validateCheese(cheese);
        if((boolean)result.get("result")) {
            //cheeseDAO.insert(cheese);
        }

        return ResponseEntity.ok().body(result);
    }

    @ResponseBody
    @RequestMapping(value = "/cheeses")
    public Map<String, List<Cheese>> getCheeses() {
        Map<String, List<Cheese>> result = new HashMap<>();
        result.put("data", cheeseDAO.getAll());
        return result;
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) Boolean error, @RequestParam(value = "logout", required = false) Boolean logout, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("msg", logout);

        return "login";
    }
}
