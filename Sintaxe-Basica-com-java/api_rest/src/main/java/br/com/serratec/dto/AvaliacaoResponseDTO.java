package br.com.serratec.dto;

import br.com.serratec.entity.Avaliacao;

public class AvaliacaoResponseDTO {

	private String tipo;
	private Integer nota;
	private String observacao;

	public AvaliacaoResponseDTO(Avaliacao ava) {
		this.tipo = ava.getTipo();
		this.nota = ava.getNota();
		this.observacao = ava.getObservacao();
	}

	public AvaliacaoResponseDTO() {
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
