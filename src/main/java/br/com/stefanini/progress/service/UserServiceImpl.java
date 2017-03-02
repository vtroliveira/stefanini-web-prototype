package br.com.stefanini.progress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.progress.model.Login;
import br.com.stefanini.progress.repository.LoginRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Login findLoginByUsername(String username) {

		return loginRepository.findByUsername(username);
	}

}
