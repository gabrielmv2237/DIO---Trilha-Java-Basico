package br.com.serratec.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.ObservacaoDTO;
import br.com.serratec.entity.ObservacaoEntity;
import br.com.serratec.entity.UsuarioAvaliadoEntity;
import br.com.serratec.repository.ObservacaoRepository;
import br.com.serratec.repository.UsuarioAvaliadoRepository;

@Service
public class ObservacaoService {

	@Autowired
	private ObservacaoRepository repository;

	@Autowired
	private UsuarioAvaliadoRepository usuario;

	// Get
	public List<ObservacaoEntity> listarTodos() {
		return repository.findAll();
	}

	// Post
	public ObservacaoDTO postarObservacao(ObservacaoDTO dto) {

		ObservacaoEntity obs = new ObservacaoEntity();

		Optional<UsuarioAvaliadoEntity> usu = usuario.findByEmail(dto.getEmail());

		obs.setData(dto.getData());
		obs.setUsuarioAvaliado(usu.get());
		obs.setIsVisible(dto.getIsVisible());
		obs.setNome(dto.getNome());
		obs.setObservacao(dto.getObservacao());
		ObservacaoEntity d = repository.save(obs);

		return new ObservacaoDTO(d);
	}

	public ObservacaoDTO postarObservacaoId(Long id,ObservacaoDTO dto) {

		ObservacaoEntity obs = new ObservacaoEntity();

		Optional<UsuarioAvaliadoEntity> usu = usuario.findById(id);

		obs.setData(dto.getData());
		obs.setUsuarioAvaliado(usu.get());
		obs.setIsVisible(dto.getIsVisible());
		obs.setNome(dto.getNome());
		obs.setObservacao(dto.getObservacao());
		ObservacaoEntity d = repository.save(obs);

		return new ObservacaoDTO(d);
	}
	
	public List<ObservacaoDTO> buscarObsDTO(String email) {

		Optional<UsuarioAvaliadoEntity> usu = usuario.findByEmail(email);

		if (usu.isPresent()) {
			List<ObservacaoEntity> ent = usu.get().getObservacoes();

			List<ObservacaoDTO> dto = ent.stream().map(entity -> new ObservacaoDTO(entity))
					.collect(Collectors.toList());

			return dto;
		} else {
			return Collections.emptyList(); // fazer tratamento de erro
		}
	}

	public ObservacaoDTO editarObs(Long id, ObservacaoDTO dto) {
		Optional<ObservacaoEntity> ent = repository.findById(id);

		if (ent.isPresent()) {
			ObservacaoEntity en = ent.get();
			en.setUsuarioAvaliado(ent.get().getUsuarioAvaliado());
			en.setId(id);
			en.setObservacao(dto.getObservacao());
			en.setData(dto.getData());
			en.setIsVisible(dto.getIsVisible());
			ObservacaoEntity d = repository.save(en);

			return new ObservacaoDTO(d);
		} else {
			return null; // fazer tratamento de erro
		}
	}

	public String delObs(Long id) {
		Optional<ObservacaoEntity> ent = repository.findById(id);
		if (ent.isPresent()) {
			ObservacaoEntity en = ent.get();
			repository.delete(en);
			return "Deletado com sucesso";
		} else {
			return "Nao existe ninguem no sistema";// fazer tratamento de erro
		}

	}
}
