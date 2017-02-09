package br.com.stefanini.progress.service;

import br.com.stefanini.progress.model.Login;

public interface LoginService {
	public Login findLoginByEmail(String email);
	//public void saveUser(Login login);

}
