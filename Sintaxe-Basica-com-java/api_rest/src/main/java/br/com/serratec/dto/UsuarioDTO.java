package br.com.serratec.dto;

import br.com.serratec.entity.UsuarioEntity;

public class UsuarioDTO {

	private String fullName;

	private String corporativeEmail;

	private String personalEmail;

	private String role;

	private String admissionDate;

	public UsuarioDTO(UsuarioEntity entity) {
		super();
		this.fullName = entity.getFullName();
		this.corporativeEmail = entity.getCorporativeEmail();
		this.personalEmail = entity.getPersonalEmail();
		this.role = entity.getRole();
		this.admissionDate = entity.getAdmissionDate();
	}

	public UsuarioDTO() {
		super();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCorporativeEmail() {
		return corporativeEmail;
	}

	public void setCorporativeEmail(String corporativeEmail) {
		this.corporativeEmail = corporativeEmail;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [fullName=" + fullName + ", corporativeEmail=" + corporativeEmail + ", personalEmail="
				+ personalEmail + ", role=" + role + ", admissionDate=" + admissionDate + "]";
	}

}
