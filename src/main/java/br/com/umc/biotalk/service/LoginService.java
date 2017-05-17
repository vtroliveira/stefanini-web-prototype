package br.com.umc.biotalk.service;

import br.com.umc.biotalk.model.Login;

public interface LoginService {
	//public Login findByUserLogin(String userLogin);
	public Login findLoginByLoginEmail(String loginEmail);
}