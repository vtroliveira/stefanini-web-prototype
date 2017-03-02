package br.com.stefanini.progress.service;

import br.com.stefanini.progress.model.Login;

public interface UserService {
	public Login findLoginByUsername(String username);
	//public void saveLogin(Login login);

}
