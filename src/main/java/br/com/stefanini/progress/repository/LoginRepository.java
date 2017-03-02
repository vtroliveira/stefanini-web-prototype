package br.com.stefanini.progress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.progress.model.Login;

@Repository("loginRepository")
public interface LoginRepository extends JpaRepository<Login, Long>{
	Login findByUsername(String username);
}
