package ma.igoudconsulting.taskmanagement.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.igoudconsulting.taskmanagement.model.User;
import ma.igoudconsulting.taskmanagement.service.RoleService;
import ma.igoudconsulting.taskmanagement.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("list-users")
	public String listUser(Model model) {
		model.addAttribute("users", userService.findAll());

		return "views/user/list-users";
	}

	@GetMapping("profile")
	public String profile() {

		return "views/user/profile";
	}

	@GetMapping("update-password")
	public String showPasswordUpdate(Model model) {
		model.addAttribute("user", new User());
		return "views/user/password";
	}

	@PostMapping("update-password")
	public String passwordUpdate(Model model, User user, HttpServletRequest request) {

		User userConnected = (User) request.getSession().getAttribute("userDB");
		userConnected.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userService.save(userConnected);
		return "redirect:/profile";
	}

	@GetMapping("add-user")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roles", roleService.findAll());
		return "views/user/add-user";
	}

	@PostMapping("add-user")
	public String addUserToDb(Model model, User user) {
		String mdp = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(mdp);
		user.setActive(true);
		userService.save(user);

		return "redirect:/list-users";
	}

	@GetMapping("delete-user")
	public String deleteUser(@RequestParam Long idUser) {

		userService.delete(idUser);
		return "redirect:/list-users";

	}

	@GetMapping("edit-user")
	public String editUser(@RequestParam Long idUser, Model model) {

		model.addAttribute("user", userService.findOne(idUser).get());
		model.addAttribute("roles", roleService.findAll());
		return "views/user/add-user";

	}

	@GetMapping("detail-user")
	public String detailUser(@RequestParam Long idUser, Model model) {
		model.addAttribute("user", userService.findOne(idUser).get());
		return "views/user/detail-user";

	}

}
