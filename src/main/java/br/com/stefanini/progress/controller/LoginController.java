package br.com.stefanini.progress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.stefanini.progress.model.Login;
import br.com.stefanini.progress.service.UserService;

@Controller
public class LoginController {
	
  @Autowired
	private UserService userService;
  
  	@RequestMapping(value={"/","/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/progress/index", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Login login = userService.findLoginByUsername(auth.getName());
		modelAndView.setViewName("progress/index");
		return modelAndView;
	}
	
}
