package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.UsuarioQueSeraAvaliadoResponseDTO;
import br.com.serratec.service.UsuarioService;

@RestController
@RequestMapping("/avaliar")
//@CrossOrigin(originPatterns = "*")
public class UsuarioAserAvaliadoController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioQueSeraAvaliadoResponseDTO>> getAllUsers(){
        return ResponseEntity.ok(service.pegarTodosUsuarios());
    }

    @GetMapping("/colaboradores")
    public ResponseEntity<List<UsuarioQueSeraAvaliadoResponseDTO>> getAllCollaborators(){
        return ResponseEntity.ok(service.pegarTodosColaboradores());
    }
}
