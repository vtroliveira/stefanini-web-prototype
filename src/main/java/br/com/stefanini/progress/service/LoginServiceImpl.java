package br.com.stefanini.progress.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.stefanini.progress.model.Login;
import br.com.stefanini.progress.model.Permission;
import br.com.stefanini.progress.repository.LoginRepository;
import br.com.stefanini.progress.repository.PermissionRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
    private PermissionRepository permissionRepository;
	
	@Override
	public Login findLoginByUsername(String username) {
		return loginRepository.findByUsername(username);
	}
  
	@Override
	public void saveLogin(Login login) {	
		login.setActive(1);
		Permission loginPermission = permissionRepository.findByPermission("ADMIN");
		login.setPermission(new HashSet<Permission>(Arrays.asList(loginPermission)));
        loginRepository.save(login);
	}

}
