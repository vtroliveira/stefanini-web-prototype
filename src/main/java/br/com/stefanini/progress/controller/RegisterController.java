package br.com.stefanini.progress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		return modelAndView;
	}

	// @RequestMapping(value="/register", method = RequestMethod.GET)
	// public ModelAndView registration(){
	// ModelAndView modelAndView = new ModelAndView();
	// User user = new User();
	// modelAndView.addObject("user", user);
	// modelAndView.setViewName("register");
	// return modelAndView;
	// }

	// @RequestMapping(value = "/register", method = RequestMethod.POST)
	// public ModelAndView createNewUser(@Valid User user, BindingResult
	// bindingResult) {
	// ModelAndView modelAndView = new ModelAndView();
	// User userExists = userService.findUserByEmail(user.getEmail());
	// if (userExists != null) {
	// bindingResult
	// .rejectValue("email", "error.user",
	// "There is already a user registered with the email provided");
	// }
	// if (bindingResult.hasErrors()) {
	// modelAndView.setViewName("registration");
	// } else {
	// userService.saveUser(user);
	// modelAndView.addObject("successMessage", "User has been registered
	// successfully");
	// modelAndView.addObject("user", new User());
	// modelAndView.setViewName("registration");
	//
	// }
	// return modelAndView;
	// }
}