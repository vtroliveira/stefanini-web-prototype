package br.com.stefanini.progress.service;

import br.com.stefanini.progress.model.Login;

public interface LoginService {
	public Login findLoginByUsername(String userLogin);
	public void saveLogin(Login login);

}
