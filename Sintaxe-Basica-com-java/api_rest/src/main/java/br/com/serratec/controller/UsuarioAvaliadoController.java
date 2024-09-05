package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.UsuarioAvaliacaoDTO;
import br.com.serratec.entity.UsuarioAvaliadoEntity;
import br.com.serratec.service.UsuarioAvaliadoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/avaliacao")
//@CrossOrigin(originPatterns = "http://34.41.164.86:3005/")
//@CrossOrigin(originPatterns = "*")
public class UsuarioAvaliadoController {

    @Autowired
    private UsuarioAvaliadoService service;

    @GetMapping("/avaliadoall")
    public ResponseEntity<List<UsuarioAvaliadoEntity>> listarTodos(){
        return ResponseEntity.ok(service.listarUsuariosAvaliados());
    }
    
    @GetMapping("/avaliadoalltrue")
    public ResponseEntity<List<UsuarioAvaliadoEntity>> listarTodosTrue(){
        return ResponseEntity.ok(service.listarTodosTrue());
    }
    
    @GetMapping("/avaliadoallfalse")
    public ResponseEntity<List<UsuarioAvaliadoEntity>> listarTodosFalse(){
    	return ResponseEntity.ok(service.listarTodosFalse());
    }
    
    @PostMapping("/avaliando")
    public ResponseEntity<UsuarioAvaliacaoDTO> inserir(@Valid @RequestBody UsuarioAvaliacaoDTO usuario){
        System.out.println("Received UsuarioAvaliadoEntity: " + usuario.toString());
        UsuarioAvaliacaoDTO savedUsuario = service.inserirUsuarioAvaliado(usuario);
        return ResponseEntity.ok(savedUsuario);
    }
    
    @GetMapping("/avaliadoemail/{email}")
    public ResponseEntity<UsuarioAvaliacaoDTO> buscarEmail(@PathVariable("email") String email) {
    	return ResponseEntity.ok(service.buscarEmail(email));
    }
    
    @GetMapping("/avaliadoid/{id}")
    public ResponseEntity<UsuarioAvaliacaoDTO> buscarId(@PathVariable("id") Long id) {
    	return ResponseEntity.ok(service.buscarId(id));
    }
}
