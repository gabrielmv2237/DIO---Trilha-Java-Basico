package br.com.serratec.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UsuarioEntity {

	@ManyToOne
	@JoinColumn(name = "id_data")
	private DataEntity data;
	@Id
	private String id;
	private String fullName;
	private String corporativeEmail;
	private String personalEmail;
	private String active;
	private String phone;
	private String cpf;
	private String role = "Programador";
	private String birthDate;
	private String admissionDate;
	private String logradouro;
	private String bairro;
	private String numero;
	private String complemento;
	private String cidade;
	private String uf;
	private String cep;
	
	
	
	public DataEntity getData() {
		return data;
	}
	public void setData(DataEntity data) {
		this.data = data;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	@Override
	public String toString() {
		return "UsuarioEntity [data=" + data + ", id=" + id + ", fullName=" + fullName + ", corporativeEmail="
				+ corporativeEmail + ", personalEmail=" + personalEmail + ", active=" + active + ", phone=" + phone
				+ ", cpf=" + cpf + ", role=" + role + ", birthDate=" + birthDate + ", admissionDate=" + admissionDate
				+ ", logradouro=" + logradouro + ", bairro=" + bairro + ", numero=" + numero + ", complemento="
				+ complemento + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + "]";
	}
	
	

}
