package br.com.stefanini.progress.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_login")
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cd_id_login")
	private int idLogin;

	// @NotEmpty(message = "*Por favor, insira seu usuário!")
	@Column(name = "fd_user_login")
	private String userLogin;

	// @Length(min = 6, message = "*Sua senha deve conter, no mínimo, 6
	// caracteres!")
	// @NotEmpty(message = "*Por favor, insira sua senha!")
	
	@Column(name = "fd_password_login")
	private String passwordLogin;

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}
	
	

}