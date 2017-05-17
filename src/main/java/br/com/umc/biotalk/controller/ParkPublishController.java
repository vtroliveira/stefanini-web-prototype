package br.com.umc.biotalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParkPublishController {

	@RequestMapping(value="/park-publish", method = RequestMethod.GET)
	public ModelAndView parkRegistration(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/park-publish");
		return modelAndView;
	}
}
