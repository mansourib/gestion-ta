package ma.igoudconsulting.taskmanagement.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ma.igoudconsulting.taskmanagement.constantes.RoleConstante;
import ma.igoudconsulting.taskmanagement.constantes.StateConstante;
import ma.igoudconsulting.taskmanagement.model.Task;
import ma.igoudconsulting.taskmanagement.model.User;
import ma.igoudconsulting.taskmanagement.model.UserTask;
import ma.igoudconsulting.taskmanagement.service.TaskService;
import ma.igoudconsulting.taskmanagement.service.UserService;
import ma.igoudconsulting.taskmanagement.service.UserTaskService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;

	@Autowired
	UserTaskService userTaskService;

	@Autowired
	TaskService taskService;

	@GetMapping("/home")
	public String index(Model model, Principal p, HttpServletRequest request) {
		User connectedUser = userService.findByEmail(p.getName());
		if (connectedUser.getRole().getCode().equals(RoleConstante.ROLE_ADMIN)) {
			model.addAttribute("newState", taskService.countByStateCode(StateConstante.NEW));
			model.addAttribute("todoState", taskService.countByStateCode(StateConstante.TODO));
			model.addAttribute("doneState", taskService.countByStateCode(StateConstante.DONE));
			model.addAttribute("allState", taskService.count());

			model.addAttribute("listNew", taskService.findByStateCode(StateConstante.NEW));

			model.addAttribute("listTodo", taskService.findByStateCode(StateConstante.TODO));
			model.addAttribute("listDone", taskService.findByStateCode(StateConstante.DONE));
		}

		if (connectedUser.getRole().getCode().equals(RoleConstante.ROLE_USER)) {

			List<Task> taskNew = new ArrayList<Task>();

			for (UserTask userTask : userTaskService.findByUserEmailAndTaskStateCode(connectedUser.getEmail(),
					StateConstante.NEW)) {
				taskNew.add(userTask.getTask());

			}
			model.addAttribute("listNew", taskNew);

			List<Task> taskTodo = new ArrayList<Task>();

			for (UserTask userTask : userTaskService.findByUserEmailAndTaskStateCode(connectedUser.getEmail(),
					StateConstante.TODO)) {
				taskTodo.add(userTask.getTask());

			}
			model.addAttribute("listTodo", taskTodo);
			List<Task> taskDone = new ArrayList<Task>();

			for (UserTask userTask : userTaskService.findByUserEmailAndTaskStateCode(connectedUser.getEmail(),
					StateConstante.DONE)) {
				taskDone.add(userTask.getTask());

			}

			model.addAttribute("newState", taskNew.size());
			model.addAttribute("todoState", taskTodo.size());
			model.addAttribute("doneState", taskDone.size());
			model.addAttribute("allState", taskNew.size() + taskTodo.size() + taskDone.size());

			model.addAttribute("listDone", taskDone);
		}

		request.getSession().setAttribute("userDB", connectedUser);
		return "index";
	}

	@RequestMapping(value = { "/", "/login", "index" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

}
