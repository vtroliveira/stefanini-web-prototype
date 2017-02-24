package br.com.stefanini.progress.service;

import org.springframework.stereotype.Service;

import br.com.stefanini.progress.model.Login;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Override
	public Login findLoginByUsername(String username) {

		return null;
	}
  
	@Override
	public void saveLogin(Login login) {	

	}

}
