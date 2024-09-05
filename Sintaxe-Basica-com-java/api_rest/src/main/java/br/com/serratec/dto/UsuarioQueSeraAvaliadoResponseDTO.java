package br.com.serratec.dto;

import br.com.serratec.entity.UsuarioEntity;

public class UsuarioQueSeraAvaliadoResponseDTO {

	private String colaborador;
	
	private String cargo;
	
	private String empresa;

	private String email;

	// Vazio
	public UsuarioQueSeraAvaliadoResponseDTO() {
	}

	public UsuarioQueSeraAvaliadoResponseDTO(UsuarioEntity usu) {
		this.colaborador = usu.getFullName();
		this.cargo = usu.getRole(); // Mockado por favor ignorar
		this.empresa = "T2M";
		this.email = usu.getCorporativeEmail();
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UsuarioQueSeraAvaliadoResponseDTO [colaborador=" + colaborador + ", cargo=" + cargo + ", empresa="
				+ empresa + "]";
	}

}
