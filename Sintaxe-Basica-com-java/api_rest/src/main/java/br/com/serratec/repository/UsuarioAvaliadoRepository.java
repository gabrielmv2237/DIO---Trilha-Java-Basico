package br.com.serratec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.entity.UsuarioAvaliadoEntity;

@Repository
public interface UsuarioAvaliadoRepository extends JpaRepository<UsuarioAvaliadoEntity, Long> {

	Optional<UsuarioAvaliadoEntity> findByEmail(String email);

}
