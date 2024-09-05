package br.com.serratec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.UsuarioQueSeraAvaliadoResponseDTO;
import br.com.serratec.entity.UsuarioEntity;
import br.com.serratec.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // Get All (idependente do role!)
    public List<UsuarioQueSeraAvaliadoResponseDTO> pegarTodosUsuarios() {

        List<UsuarioEntity> users = new ArrayList<>();
        List<UsuarioQueSeraAvaliadoResponseDTO> usuariosQueSeraoAvaliados = new ArrayList<>();
        users = repository.findAll();

        for (UsuarioEntity user : users) {
            UsuarioQueSeraAvaliadoResponseDTO dto = new UsuarioQueSeraAvaliadoResponseDTO();
            
            dto.setColaborador(user.getFullName());
            dto.setCargo("Programador");
            dto.setEmpresa("T2M");
            dto.setEmail(user.getCorporativeEmail());
            
            usuariosQueSeraoAvaliados.add(dto);
            }
        
        return usuariosQueSeraoAvaliados;
    }


    //Get All (Filtrando Role)
    public List<UsuarioQueSeraAvaliadoResponseDTO> pegarTodosColaboradores() {

        List<UsuarioEntity> users = new ArrayList<>();
        List<UsuarioQueSeraAvaliadoResponseDTO> usuariosQueSeraoAvaliados = new ArrayList<>();
        users = repository.findAll();

        for (UsuarioEntity user : users) {
            if(user.getRole().equals("0")){
            UsuarioQueSeraAvaliadoResponseDTO dto = new UsuarioQueSeraAvaliadoResponseDTO();
            
            dto.setCargo("Programador");
            dto.setColaborador(user.getFullName());
            dto.setEmpresa("T2M");
            dto.setEmail(user.getCorporativeEmail());
            
            usuariosQueSeraoAvaliados.add(dto);
            }
        }

        //Teste para ver se está getando direitinho
        System.out.println(usuariosQueSeraoAvaliados.size());

        return usuariosQueSeraoAvaliados;
    }
}
