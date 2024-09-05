package br.com.serratec.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.serratec.entity.UsuarioAvaliadoEntity;

public class UsuarioAvaliacaoDTO {

	private Long id;

	private String nome;

	private String email;

	private String empresa;

	private String periodo;

	private LocalDate dataAvaliacao = LocalDate.now();

	private AvaliacaoResponseDTO comportamental;

	private AvaliacaoResponseDTO tecnico;

	private AvaliacaoResponseDTO entrega;

	private List<ObservacaoDTO> observacoes;

	public UsuarioAvaliacaoDTO() {
	}

	public UsuarioAvaliacaoDTO(UsuarioAvaliadoEntity usu) {
		super();
		this.id = usu.getId();
		this.nome = usu.getNome();
		this.email = usu.getEmail();
		this.empresa = usu.getEmpresa();
		this.periodo = usu.getPeriodo();
		this.dataAvaliacao = usu.getDataAvaliacao();
		this.comportamental = new AvaliacaoResponseDTO(usu.getComportamental());
		this.tecnico = new AvaliacaoResponseDTO(usu.getTecnico());
		this.entrega = new AvaliacaoResponseDTO(usu.getEntrega());
		this.observacoes = usu.getObservacoes().stream().map(obs -> new ObservacaoDTO(obs))
				.collect(Collectors.toList());

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public LocalDate getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(LocalDate dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public AvaliacaoResponseDTO getComportamental() {
		return comportamental;
	}

	public void setComportamental(AvaliacaoResponseDTO comportamental) {
		this.comportamental = comportamental;
	}

	public AvaliacaoResponseDTO getTecnico() {
		return tecnico;
	}

	public void setTecnico(AvaliacaoResponseDTO tecnico) {
		this.tecnico = tecnico;
	}

	public AvaliacaoResponseDTO getEntrega() {
		return entrega;
	}

	public void setEntrega(AvaliacaoResponseDTO entrega) {
		this.entrega = entrega;
	}

	public List<ObservacaoDTO> getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(List<ObservacaoDTO> observacoes) {
		this.observacoes = observacoes;
	}

}
