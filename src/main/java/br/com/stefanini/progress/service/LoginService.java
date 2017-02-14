
package br.com.stefanini.progress.service;

import br.com.stefanini.progress.model.Login;

public interface LoginService {
	public Login findLoginByUsername(String username);
	public void saveLogin(Login login);

}
