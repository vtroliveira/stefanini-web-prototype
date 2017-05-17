package br.com.umc.biotalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForgotPasswordController {
	
	@RequestMapping(value= {"/forgotPassword"}, method=RequestMethod.GET)
	public ModelAndView forgotPassword(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forgotPassword");
		return modelAndView;
	}
}
