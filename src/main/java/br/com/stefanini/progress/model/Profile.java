package br.com.stefanini.progress.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_profile")
public class Profile implements Serializable	{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cd_id_profile")
	//@NotEmpty(message = "*Por favor, insira seu usuário!")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProfile;
	
	@Column(name="fd_desc_profile")
	private String descProfile;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="cd_id_profile")
	private List<User> user;

	public int getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}

	public String getDescProfile() {
		return descProfile;
	}

	public void setDescProfile(String descProfile) {
		this.descProfile = descProfile;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
	
	
}
