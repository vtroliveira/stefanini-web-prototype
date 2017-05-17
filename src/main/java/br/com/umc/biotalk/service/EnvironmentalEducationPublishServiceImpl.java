package br.com.umc.biotalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.umc.biotalk.model.EnvironmentalEducationPublish;
import br.com.umc.biotalk.model.Login;
import br.com.umc.biotalk.repository.EnvironmentalEducationPublishRepository;
import br.com.umc.biotalk.repository.LoginRepository;

@Service("environmentEducationPublishService")
public class EnvironmentalEducationPublishServiceImpl implements EnvironmentalEducationPublishService{

	@Autowired
	private EnvironmentalEducationPublishRepository environmentalEducationPublishRepository;
	
	@Override
	public void saveEnvironmentalEducationPublish(EnvironmentalEducationPublish environmentalEducationPublish) {

		environmentalEducationPublish.setEnvironmentalPublisNameUser(environmentalEducationPublish.getEnvironmentalPublisNameUser());
		environmentalEducationPublish.setEnvironmentalPublisPhone(environmentalEducationPublish.getEnvironmentalPublisPhone());
		environmentalEducationPublish.setEnvironmentalPublisEmail(environmentalEducationPublish.getEnvironmentalPublisEmail());
		environmentalEducationPublish.setEnvironmentalPublishNameProject(environmentalEducationPublish.getEnvironmentalPublishNameProject());
		environmentalEducationPublish.setEnvironmentalPublishDesc(environmentalEducationPublish.getEnvironmentalPublishDesc());
		environmentalEducationPublish.setEnvironmentalPublishPhoto(environmentalEducationPublish.getEnvironmentalPublishPhoto());
		
		environmentalEducationPublishRepository.save(environmentalEducationPublish);
		
	}
	
	
}
