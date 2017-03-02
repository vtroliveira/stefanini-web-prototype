package br.com.stefanini.progress.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "tb_login")
public class Login implements Serializable {	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cd_id_login")
	private int idLogin;

	// @NotEmpty(message = "*Por favor, insira seu usuário!")
	@Column(name = "fd_username")
	private String username;

	@Length(min = 6, message = "*Sua senha deve conter, no mínimo, 6 caracteres!")
	// @NotEmpty(message = "*Por favor, insira sua senha!")	
	@Column(name = "fd_password")
	private String password;

	@Column(name="fd_active_user")
	private Boolean activeUser;

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getUsername() {
		return username;
	}

	public Boolean isActiveUser() {
		return activeUser;
	}

	public void setActiveUser(Boolean activeUser) {
		this.activeUser = activeUser;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}