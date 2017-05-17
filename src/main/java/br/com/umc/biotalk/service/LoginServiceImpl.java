package br.com.umc.biotalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.umc.biotalk.model.Login;
import br.com.umc.biotalk.repository.LoginRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public Login findLoginByLoginEmail(String loginEmail) {
		return loginRepository.findByLoginEmail(loginEmail);
	}
	
  
}