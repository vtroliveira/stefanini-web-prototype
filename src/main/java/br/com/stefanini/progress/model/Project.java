package br.com.stefanini.progress.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dom_project")
public class Project implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_id_project")
	private int idProject;

	@Column(name = "fd_desc_project")
	private String descProject;

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getDescProject() {
		return descProject;
	}

	public void setDescProject(String descProject) {
		this.descProject = descProject;
	}
}
