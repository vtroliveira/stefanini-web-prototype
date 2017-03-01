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
	public Login findLoginByUserLogin(String userLogin) {
		return loginRepository.findByUserLogin(userLogin);
	}
  
//	@Override
//	public void saveLogin(Login login) {	
//		login.setPasswordLogin(login.getPasswordLogin());
//		loginRepository.save(login);
//	}

}