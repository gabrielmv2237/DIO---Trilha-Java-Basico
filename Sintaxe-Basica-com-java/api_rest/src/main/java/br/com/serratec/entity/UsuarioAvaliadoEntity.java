package br.com.serratec.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class UsuarioAvaliadoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String email;

	private String empresa;
	
	@NotBlank
	@NotEmpty(message = "Periodo vazio")
	private String periodo;

	private LocalDate dataAvaliacao = LocalDate.now();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "comportamental_id")
	private Avaliacao comportamental;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tecnico_id")
	private Avaliacao tecnico;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "entrega_id")
	private Avaliacao entrega;

	@OneToMany(mappedBy = "usuarioAvaliado", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ObservacaoEntity> observacoes = new ArrayList<>();

	public UsuarioAvaliadoEntity() {
	}

	public UsuarioAvaliadoEntity(Long id, String nome, String email, String empresa, String periodo,
			LocalDate dataAvaliacao, Avaliacao comportamental, Avaliacao tecnico, Avaliacao entrega,
			List<ObservacaoEntity> observacoes) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.empresa = empresa;
		this.periodo = periodo;
		this.dataAvaliacao = dataAvaliacao;
		this.comportamental = comportamental;
		this.tecnico = tecnico;
		this.entrega = entrega;
		this.observacoes = observacoes;
	}

	@Override
	public String toString() {
		return "UsuarioAvaliadoEntity [id=" + id + ", nome=" + nome + ", email=" + email + ", empresa=" + empresa
				+ ", periodo=" + periodo + ", dataAvaliacao=" + dataAvaliacao + ", comportamental=" + comportamental
				+ ", tecnico=" + tecnico + ", entrega=" + entrega + ", observacoes=" + observacoes + "]";
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

	public Avaliacao getComportamental() {
		return comportamental;
	}

	public void setComportamental(Avaliacao comportamental) {
		this.comportamental = comportamental;
	}

	public Avaliacao getTecnico() {
		return tecnico;
	}

	public void setTecnico(Avaliacao tecnico) {
		this.tecnico = tecnico;
	}

	public Avaliacao getEntrega() {
		return entrega;
	}

	public void setEntrega(Avaliacao entrega) {
		this.entrega = entrega;
	}

	public List<ObservacaoEntity> getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(List<ObservacaoEntity> observacoes) {
		this.observacoes = observacoes;
	}

}
