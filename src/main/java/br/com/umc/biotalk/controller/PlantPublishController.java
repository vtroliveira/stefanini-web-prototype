package br.com.umc.biotalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlantPublishController {
	
	@RequestMapping(value="/plant-publish", method = RequestMethod.GET)
	public ModelAndView plantRegistration(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/plant-publish");
		return modelAndView;
	}

}
