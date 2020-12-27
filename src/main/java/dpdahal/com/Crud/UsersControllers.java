package dpdahal.com.Crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UsersControllers {
	@Autowired
	private UsersService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Users>listUsers = service.listAll();
		model.addAttribute("listUsers", listUsers);
		
		return "index";
	}
	
	@RequestMapping("/add-new-user")
	public String addNewUser(Model model) {
		Users users = new Users();	
		model.addAttribute("users",users);
		return "add_new_user";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String addNewUserAction(@ModelAttribute("users") Users users) {
		service.save(users);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditUserForm(@PathVariable(name="id") Long id) {
		ModelAndView data = new ModelAndView("update_user");
		Users users = service.get(id);
		data.addObject("users",users);
		return data;
		
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name="id") Long id) {
		service.delete(id);
		return "redirect:/";
	}
}
