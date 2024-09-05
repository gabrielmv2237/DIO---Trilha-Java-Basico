package br.com.serratec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.AvaliacaoResponseDTO;
import br.com.serratec.dto.ObservacaoDTO;
import br.com.serratec.dto.UsuarioAvaliacaoDTO;
import br.com.serratec.entity.Avaliacao;
import br.com.serratec.entity.ObservacaoEntity;
import br.com.serratec.entity.UsuarioAvaliadoEntity;
import br.com.serratec.exception.AvaliacaoException;
import br.com.serratec.repository.UsuarioAvaliadoRepository;

@Service
public class UsuarioAvaliadoService {

	@Autowired
	private UsuarioAvaliadoRepository repository;

	// Get só para teste
	
	public List<UsuarioAvaliadoEntity> listarUsuariosAvaliados(){
		return repository.findAll();
	}
	
	public List<UsuarioAvaliadoEntity> listarTodosTrue() {

		List<UsuarioAvaliadoEntity> usuarios = repository.findAll();
		List<UsuarioAvaliadoEntity> resultado = new ArrayList<>();

		for (UsuarioAvaliadoEntity usuario : usuarios) {

			UsuarioAvaliadoEntity ent = new UsuarioAvaliadoEntity();

			ent.setId(usuario.getId());
			ent.setNome(usuario.getNome());
			ent.setEmail(usuario.getEmail());
			ent.setEmpresa(usuario.getEmpresa());
			ent.setPeriodo(usuario.getPeriodo());
			ent.setDataAvaliacao(usuario.getDataAvaliacao());
			ent.setComportamental(usuario.getComportamental());
			ent.setTecnico(usuario.getTecnico());
			ent.setEntrega(usuario.getEntrega());
			ent.setObservacoes(new ArrayList<>());

			for (ObservacaoEntity obs : usuario.getObservacoes()) {

				if (Boolean.TRUE.equals(obs.getIsVisible())) {
					ObservacaoEntity observacao = new ObservacaoEntity();
					observacao.setId(obs.getId());
					observacao.setNome(obs.getNome());
					observacao.setData(obs.getData());
					observacao.setObservacao(obs.getObservacao());
					observacao.setIsVisible(obs.getIsVisible());
					observacao.setUsuarioAvaliado(ent);
					ent.getObservacoes().add(observacao);
				}
			}

			resultado.add(ent);

		}

		return resultado;

	}

	public List<UsuarioAvaliadoEntity> listarTodosFalse() {
		List<UsuarioAvaliadoEntity> usuarios = repository.findAll();
		List<UsuarioAvaliadoEntity> resultado = new ArrayList<>();

		for (UsuarioAvaliadoEntity usuario : usuarios) {

			UsuarioAvaliadoEntity ent = new UsuarioAvaliadoEntity();

			ent.setId(usuario.getId());
			ent.setNome(usuario.getNome());
			ent.setEmail(usuario.getEmail());
			ent.setEmpresa(usuario.getEmpresa());
			ent.setPeriodo(usuario.getPeriodo());
			ent.setDataAvaliacao(usuario.getDataAvaliacao());
			ent.setComportamental(usuario.getComportamental());
			ent.setTecnico(usuario.getTecnico());
			ent.setEntrega(usuario.getEntrega());
			ent.setObservacoes(new ArrayList<>());

			for (ObservacaoEntity obs : usuario.getObservacoes()) {
				if (Boolean.FALSE.equals(obs.getIsVisible())) {
					ObservacaoEntity observacao = new ObservacaoEntity();
					observacao.setId(obs.getId());
					observacao.setNome(obs.getNome());
					observacao.setData(obs.getData());
					observacao.setObservacao(obs.getObservacao());
					observacao.setIsVisible(obs.getIsVisible());
					observacao.setUsuarioAvaliado(ent);
					ent.getObservacoes().add(observacao);
				}
			}

			resultado.add(ent);

		}

		return resultado;
	}

	// Post do maluco
	public UsuarioAvaliacaoDTO inserirUsuarioAvaliado(UsuarioAvaliacaoDTO dto) throws AvaliacaoException {
		// Lista para os possíveis erros. se tiver algo dentro da lista ele vai lançar a
		// Exception!
		List<String> erros = new ArrayList<>();

		UsuarioAvaliadoEntity usu = new UsuarioAvaliadoEntity();

		// Bloco das verificações antes de de fato continuar com o código!
		if (dto.getNome() == null || dto.getNome().isEmpty())
			erros.add("O nome está nulo!");
		if (dto.getEmail() == null || dto.getEmail().isEmpty())
			erros.add("O Email está Nulo!");
		if (!dto.getEmail().contains("@"))
			erros.add("Está faltando @ no email!!!");
		if (dto.getEmpresa() == null || dto.getEmpresa().isEmpty())
			erros.add("O Campo empresa está nulo!");
		// if(dto.getDataAvaliacao() == null ) erros.add("Adicione uma data de
		// avaliação");
		if (dto.getComportamental().getNota() == 0
				&& (dto.getComportamental().getObservacao() == null || dto.getComportamental().getObservacao() == ""))
			erros.add("Comportamental: É obrigatório colocar uma observação no caso não tenha dado estrelas.");
		// if(! (dto.getComportamental().getTipo() == "comportamental") )
		// erros.add("Comportamental: O Tipo nesse Json tem que ser 'comportamental'");
		if (dto.getTecnico().getNota() == 0
				&& (dto.getTecnico().getObservacao() == null || dto.getTecnico().getObservacao() == ""))
			erros.add("Tecnico: É obrigatório colocar uma observação no caso não tenha dado estrelas.");
		// if(! (dto.getTecnico().getTipo() == "tecnico") ) erros.add("Tecnico: O Tipo
		// nesse Json tem que ser 'tecnico'");
		if (dto.getEntrega().getNota() == 0
				&& (dto.getEntrega().getObservacao() == null || dto.getEntrega().getObservacao() == ""))
			erros.add("Entrega: É obrigatório colocar uma observação no caso não tenha dado estrelas.");
		// if(! (dto.getEntrega().getTipo() == "entrega") ) erros.add("Entrega: O Tipo
		// nesse Json tem que ser 'entrega'");

		if (!erros.isEmpty())
			throw new AvaliacaoException(erros);

		usu.setId(dto.getId());
		usu.setNome(dto.getNome());
		usu.setDataAvaliacao(dto.getDataAvaliacao());
		usu.setEmail(dto.getEmail());
		usu.setEmpresa("T2M");
		usu.setPeriodo(dto.getPeriodo());

		Avaliacao ava = new Avaliacao();
		ava.setTipo(dto.getComportamental().getTipo());
		ava.setNota(dto.getComportamental().getNota());
		ava.setObservacao(dto.getComportamental().getObservacao());
		usu.setComportamental(ava);

		Avaliacao ava2 = new Avaliacao();
		ava2.setTipo(dto.getEntrega().getTipo());
		ava2.setNota(dto.getEntrega().getNota());
		ava2.setObservacao(dto.getEntrega().getObservacao());
		usu.setEntrega(ava2);

		Avaliacao ava3 = new Avaliacao();
		ava3.setTipo(dto.getTecnico().getTipo());
		ava3.setNota(dto.getTecnico().getNota());
		ava3.setObservacao(dto.getTecnico().getObservacao());
		usu.setTecnico(ava3);

		for (ObservacaoDTO obsDto : dto.getObservacoes()) {
			ObservacaoEntity obs = new ObservacaoEntity();
			obs.setNome(obsDto.getNome());
			obs.setData(obsDto.getData());
			obs.setObservacao(obsDto.getObservacao());
			obs.setIsVisible(obsDto.getIsVisible());
			obs.setUsuarioAvaliado(usu);
			usu.getObservacoes().add(obs);
		}

		usu = repository.save(usu);

		return new UsuarioAvaliacaoDTO(usu);
	}

	public UsuarioAvaliacaoDTO buscarEmail(String email) {
		Optional<UsuarioAvaliadoEntity> usu = repository.findByEmail(email);
		List<ObservacaoDTO> resultado = new ArrayList<>();
		List<String> erros = new ArrayList<>();
		if (usu.isPresent()) {
			UsuarioAvaliacaoDTO dto = new UsuarioAvaliacaoDTO();

			dto.setId(usu.get().getId());
			dto.setNome(usu.get().getNome());
			dto.setDataAvaliacao(usu.get().getDataAvaliacao());
			dto.setEmail(usu.get().getEmail());
			dto.setEmpresa("T2M");
			dto.setPeriodo(usu.get().getPeriodo());

			AvaliacaoResponseDTO ava = new AvaliacaoResponseDTO();
			ava.setTipo(usu.get().getComportamental().getTipo());
			ava.setNota(usu.get().getComportamental().getNota());
			ava.setObservacao(usu.get().getComportamental().getObservacao());
			dto.setComportamental(ava);

			AvaliacaoResponseDTO ava2 = new AvaliacaoResponseDTO();
			ava2.setTipo(usu.get().getEntrega().getTipo());
			ava2.setNota(usu.get().getEntrega().getNota());
			ava2.setObservacao(usu.get().getEntrega().getObservacao());
			dto.setEntrega(ava2);

			AvaliacaoResponseDTO ava3 = new AvaliacaoResponseDTO();
			ava3.setTipo(usu.get().getTecnico().getTipo());
			ava3.setNota(usu.get().getTecnico().getNota());
			ava3.setObservacao(usu.get().getTecnico().getObservacao());
			dto.setTecnico(ava3);

			for (ObservacaoEntity obsDto : usu.get().getObservacoes()) {
				ObservacaoDTO obs = new ObservacaoDTO();
				
				obs.setNome(obsDto.getNome());
				obs.setData(obsDto.getData());
				obs.setEmail(usu.get().getEmail());
				obs.setIsVisible(obsDto.getIsVisible());
				obs.setObservacao(obsDto.getObservacao());
				obs.setIsVisible(obsDto.getIsVisible());
				resultado.add(obs);
			}
			dto.setObservacoes(resultado);
			return dto;
		} else
			erros.add("Nenhum usuario encontrado");
		throw new AvaliacaoException(erros);
	}

	public UsuarioAvaliacaoDTO buscarId(Long id) {
		Optional<UsuarioAvaliadoEntity> usu = repository.findById(id);
		List<ObservacaoDTO> resultado = new ArrayList<>();
		List<String> erros = new ArrayList<>();
		if (usu.isPresent()) {
			UsuarioAvaliacaoDTO dto = new UsuarioAvaliacaoDTO();

			dto.setId(usu.get().getId());
			dto.setNome(usu.get().getNome());
			dto.setDataAvaliacao(usu.get().getDataAvaliacao());
			dto.setEmail(usu.get().getEmail());
			dto.setEmpresa("T2M");
			dto.setPeriodo(usu.get().getPeriodo());

			AvaliacaoResponseDTO ava = new AvaliacaoResponseDTO();
			ava.setTipo(usu.get().getComportamental().getTipo());
			ava.setNota(usu.get().getComportamental().getNota());
			ava.setObservacao(usu.get().getComportamental().getObservacao());
			dto.setComportamental(ava);

			AvaliacaoResponseDTO ava2 = new AvaliacaoResponseDTO();
			ava2.setTipo(usu.get().getEntrega().getTipo());
			ava2.setNota(usu.get().getEntrega().getNota());
			ava2.setObservacao(usu.get().getEntrega().getObservacao());
			dto.setEntrega(ava2);

			AvaliacaoResponseDTO ava3 = new AvaliacaoResponseDTO();
			ava3.setTipo(usu.get().getTecnico().getTipo());
			ava3.setNota(usu.get().getTecnico().getNota());
			ava3.setObservacao(usu.get().getTecnico().getObservacao());
			dto.setTecnico(ava3);

			for (ObservacaoEntity obsDto : usu.get().getObservacoes()) {
				ObservacaoDTO obs = new ObservacaoDTO();
				
				obs.setNome(obsDto.getNome());
				obs.setData(obsDto.getData());
				obs.setEmail(usu.get().getEmail());
				obs.setIsVisible(obsDto.getIsVisible());
				obs.setObservacao(obsDto.getObservacao());
				obs.setIsVisible(obsDto.getIsVisible());
				resultado.add(obs);
			}
			dto.setObservacoes(resultado);
			return dto;
		} else
			erros.add("Nenhum usuario avaliado encontrado");
		throw new AvaliacaoException(erros);
	}
}
