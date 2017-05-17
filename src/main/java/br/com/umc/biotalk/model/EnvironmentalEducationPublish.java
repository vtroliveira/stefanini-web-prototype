package br.com.umc.biotalk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "tb_environmental_education_publish")
public class EnvironmentalEducationPublish {
	
	@Id
	@Column(name = "environmental_publish_id")
	private int environmentalPublishId;
	
	@Column(name = "environmental_publish_name_user")
	private String environmentalPublisNameUser; 
	
	@Column(name = "environmental_publish_phone")
	private int environmentalPublishPhone;
	
	@Email(message = "*Por favor, insira um email válido")
	@Column(name = "environmental_publish_email")
	private String environmentalPublisEmail;
	
	@Column(name = "environmental_publish_name_project")
	private String environmentalPublishNameProject;
	
	@Column(name = "environmental_publish_desc")
	private String environmentalPublishDesc;
	
	@Column(name = "environmental_publish_photo")
	private byte[] environmentalPublishPhoto;

	public int getEnvironmentalPublishId() {
		return environmentalPublishId;
	}

	public void setEnvironmentalPublishId(int environmentalPublishId) {
		this.environmentalPublishId = environmentalPublishId;
	}

	public String getEnvironmentalPublisNameUser() {
		return environmentalPublisNameUser;
	}

	public void setEnvironmentalPublisNameUser(String environmentalPublisNameUser) {
		this.environmentalPublisNameUser = environmentalPublisNameUser;
	}

	public int getEnvironmentalPublisPhone() {
		return environmentalPublishPhone;
	}

	public void setEnvironmentalPublisPhone(int environmentalPublisPhone) {
		this.environmentalPublishPhone = environmentalPublisPhone;
	}

	public String getEnvironmentalPublisEmail() {
		return environmentalPublisEmail;
	}

	public void setEnvironmentalPublisEmail(String environmentalPublisEmail) {
		this.environmentalPublisEmail = environmentalPublisEmail;
	}

	public String getEnvironmentalPublishNameProject() {
		return environmentalPublishNameProject;
	}

	public void setEnvironmentalPublishNameProject(String environmentalPublishNameProject) {
		this.environmentalPublishNameProject = environmentalPublishNameProject;
	}

	public String getEnvironmentalPublishDesc() {
		return environmentalPublishDesc;
	}

	public void setEnvironmentalPublishDesc(String environmentalPublishDesc) {
		this.environmentalPublishDesc = environmentalPublishDesc;
	}

	public byte[] getEnvironmentalPublishPhoto() {
		return environmentalPublishPhoto;
	}

	public void setEnvironmentalPublishPhoto(byte[] environmentalPublishPhoto) {
		this.environmentalPublishPhoto = environmentalPublishPhoto;
	}

}
