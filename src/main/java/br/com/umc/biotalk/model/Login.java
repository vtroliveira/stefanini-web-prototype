package br.com.umc.biotalk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "tb_login")
public class Login {

	@Id
	@Column(name = "login_id")
	private int loginId;

	// @NotEmpty(message = "*Por favor, insira seu usuário!")
	@Email(message = "*Por favor, insira um email válido")
	@Column(name = "login_email")
	private String loginEmail;

	// @Length(min = 6, message = "*Sua senha deve conter, no mínimo, 6
	// caracteres!")
	// @NotEmpty(message = "*Por favor, insira sua senha!")
	
	@Column(name = "login_password")
	//@NotEmpty(message = "*Por favor, coloque sua senha!")
	@Transient
	private String loginPassword;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	

}