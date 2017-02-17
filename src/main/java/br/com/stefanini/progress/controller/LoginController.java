package br.com.stefanini.progress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	//@Autowired
//	private LoginService loginService;
	
	@RequestMapping(value={"/","/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
//	@RequestMapping(value="/home", method = RequestMethod.GET)
//	public ModelAndView home(){
//		ModelAndView modelAndView = new ModelAndView();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		Login login = loginService.findLoginByUsername(auth.getName());
//		modelAndView.addObject("userName", "Welcome " + login.getUsername() );
//		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
//		modelAndView.setViewName("/home");
//		return modelAndView;
//	}

}
