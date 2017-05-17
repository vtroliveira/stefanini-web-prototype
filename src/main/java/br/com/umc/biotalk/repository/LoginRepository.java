package br.com.umc.biotalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.umc.biotalk.model.Login;

@Repository("loginRepository")
public interface LoginRepository extends JpaRepository<Login, Long>{
//	Login findByUserLogin(String userLogin);
	Login findByLoginEmail(String loginEmail);
	
	
}
