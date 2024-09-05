package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.ObservacaoEntity;

public interface ObservacaoRepository extends JpaRepository<ObservacaoEntity, Long>{
}
