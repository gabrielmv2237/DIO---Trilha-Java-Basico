package br.com.serratec.dto;

import java.time.LocalDate;

import br.com.serratec.entity.ObservacaoEntity;

public class ObservacaoResponseDTO {

	private String nome;

	private LocalDate data;

	private String observacao;

	private Boolean isVisible;

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

	public Boolean getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ObservacaoResponseDTO() {
	}

	public ObservacaoResponseDTO(ObservacaoEntity obs) {
		this.nome = obs.getNome();
		this.data = obs.getData();
		this.observacao = obs.getObservacao();
		this.isVisible = obs.getIsVisible();
	}

}
