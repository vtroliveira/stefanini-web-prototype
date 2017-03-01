

package br.com.stefanini.progress.model;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cd_id_user")
	private int idUser;
	
	@OneToOne
	@JoinColumn(name="cd_id_login", foreignKey=@ForeignKey(name="fk_constraint_login"))
	private Login login;
	
	@ManyToOne
	@JoinColumn(name="cd_id_profile", foreignKey=@ForeignKey(name="fk_constraint_profile"))
	private Profile profile;
	
	@Column(name="fd_name_user")
	private String nameUser;
	
	@Column(name="fd_email_user")
	//@Email(message="*Por favor providencie um email válido")
	private String emailUser;
	
	@Column(name="cd_active_user")
	private boolean activeUser;
	
	@ManyToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE})
	@JoinTable(name = "tb_associative_user_project", joinColumns = @JoinColumn(name = "cd_id_user", foreignKey=@ForeignKey(name="fk_constraint_user")), inverseJoinColumns = @JoinColumn(name = "cd_id_project", foreignKey=@ForeignKey(name="fk_constraint_project")))
	private List<Project> project;
	


	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}


	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public boolean isActiveUser() {
		return activeUser;
	}

	public void setActiveUser(boolean activeUser) {
		this.activeUser = activeUser;
	}
	
	}
