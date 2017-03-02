package br.com.stefanini.progress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.stefanini.progress.model.Login;
import br.com.stefanini.progress.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
  
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
	Login login = loginService.findLoginByUsername(auth.getName());
	//modelAndView.addObject("userName", "Bem vinda " + login.getUserLogin());
	modelAndView.setViewName("progress/index");
	return modelAndView;
	}
	
}
