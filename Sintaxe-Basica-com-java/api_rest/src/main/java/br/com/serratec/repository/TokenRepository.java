package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.entity.LoginEntity;

@Repository
public interface TokenRepository extends JpaRepository<LoginEntity, Long> {
}
