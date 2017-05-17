package br.com.umc.biotalk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.umc.biotalk.model.EnvironmentalEducationPublish;
import br.com.umc.biotalk.service.EnvironmentalEducationPublishService;

@Controller
public class EnvironmentalEducationPublishController {

	@Autowired
	private EnvironmentalEducationPublishService service;

	@RequestMapping(value = "/environmental-education-publish", method = RequestMethod.GET)
	public ModelAndView publishEnvironmentalEducation() {
		ModelAndView modelAndView = new ModelAndView();
		EnvironmentalEducationPublish environmental = new EnvironmentalEducationPublish();

		modelAndView.addObject("nome", environmental.getEnvironmentalPublisNameUser());
		modelAndView.addObject("telefone", environmental.getEnvironmentalPublisPhone());
		modelAndView.addObject("email", environmental.getEnvironmentalPublisEmail());
		modelAndView.addObject("nomeProjeto", environmental.getEnvironmentalPublishNameProject());
		modelAndView.addObject("descricao", environmental.getEnvironmentalPublishDesc());
		modelAndView.addObject("anexarImagem", environmental.getEnvironmentalPublishPhoto());

		modelAndView.setViewName("/environmental-education-publish");
		return modelAndView;
	}

	@RequestMapping(value = "/environmental-education-publish", method = RequestMethod.POST)
	public ModelAndView save(@Valid EnvironmentalEducationPublish environmentalEducationPublish,
			BindingResult bindingResult) {

		System.out.println("submit");
		
		ModelAndView modelAndView = new ModelAndView();
		
			service.saveEnvironmentalEducationPublish(environmentalEducationPublish);
			modelAndView.addObject("environmentalEducationPublish",new EnvironmentalEducationPublish());
			modelAndView.setViewName("/environmental-education-publish");
		
		return modelAndView;
	}

}
