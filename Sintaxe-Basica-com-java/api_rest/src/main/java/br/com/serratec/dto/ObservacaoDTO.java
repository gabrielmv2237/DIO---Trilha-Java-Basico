package br.com.serratec.dto;

import java.time.LocalDate;

import br.com.serratec.entity.ObservacaoEntity;

public class ObservacaoDTO {

	// Observacao
	private String nome;
	private LocalDate data = LocalDate.now();
	private String observacao;
	private Boolean IsVisible;
	private String email;

	public ObservacaoDTO(ObservacaoEntity obs) {
		this.nome = obs.getNome();
		this.data = obs.getData();
		this.observacao = obs.getObservacao();
		this.IsVisible = obs.getIsVisible();
		this.email = obs.getUsuarioAvaliado().getEmail();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ObservacaoDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getIsVisible() {
		return IsVisible;
	}

	public void setIsVisible(Boolean isVisible) {
		IsVisible = isVisible;
	}
}
