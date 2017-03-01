package br.com.stefanini.progress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.progress.model.Login;
import br.com.stefanini.progress.repository.LoginRepository;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public Login findLoginByUsername(String userName) {

		return loginRepository.findByUserLogin(userName);
	}
  
	@Override
	public void saveLogin(Login login) {	

	}

}
