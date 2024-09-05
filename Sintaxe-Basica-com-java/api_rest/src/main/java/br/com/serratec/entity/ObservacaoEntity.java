package br.com.serratec.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.serratec.dto.ObservacaoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ObservacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate data = LocalDate.now();

    private String observacao;

    private Boolean IsVisible;

    @ManyToOne
    @JoinColumn(name = "obersavacao_id")
    @JsonBackReference
    private UsuarioAvaliadoEntity usuarioAvaliado;

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

    public UsuarioAvaliadoEntity getUsuarioAvaliado() {
        return usuarioAvaliado;
    }

    public void setUsuarioAvaliado(UsuarioAvaliadoEntity usuarioAvaliado) {
        this.usuarioAvaliado = usuarioAvaliado;
    }

    public ObservacaoEntity() {
    }

    public ObservacaoEntity(ObservacaoDTO obs) {
        this.nome = obs.getNome();
        this.data = obs.getData();
        this.observacao = obs.getObservacao();
        this.IsVisible = obs.getIsVisible();
    }
    
    public ObservacaoEntity(Long id, String nome, LocalDate data, String observacao, Boolean isVisible,
            UsuarioAvaliadoEntity usuarioAvaliado) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.observacao = observacao;
        this.IsVisible = isVisible;
        this.usuarioAvaliado = usuarioAvaliado;
    }

    @Override
    public String toString() {
        return "ObservacaoEntity [id=" + id + ", nome=" + nome + ", data=" + data + ", observacao=" + observacao
                + ", IsVisible=" + IsVisible + ", usuarioAvaliado=" + usuarioAvaliado + "]";
    }

    

}
