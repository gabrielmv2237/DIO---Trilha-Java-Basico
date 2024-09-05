package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.serratec.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioEntity, String> {
	@Query("SELECT c FROM UsuarioEntity c WHERE c.corporativeEmail = ?1")
	UsuarioEntity findByCorporativeEmail(String corporativeEmail);
}
