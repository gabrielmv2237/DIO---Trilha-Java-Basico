package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.LoginDTO;
import br.com.serratec.dto.UsuarioDTO;
import br.com.serratec.entity.DataEntity;
import br.com.serratec.service.AuthenticationService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
@CrossOrigin(originPatterns = "http://localhost:5173")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService service;
	
    @PostMapping("/login")
    public  ResponseEntity<String> loginPost(@RequestBody @Valid LoginDTO login) {
        //return ResponseEntity.ok(service.loginPost(login));
        String verifica = service.loginPost(login);
        if(verifica.length() <= 1) return ResponseEntity.badRequest().body(null);
        else return ResponseEntity.ok(service.loginPost(login));
    }
    
    @GetMapping("/usuario")
    public ResponseEntity<DataEntity> consultaUsuario(@RequestBody @Valid String loginUsuario) {
    	return ResponseEntity.ok(service.consultaUsuario(loginUsuario));
    }
    
    @GetMapping("/tela/{email}")
    public ResponseEntity<UsuarioDTO> consultaRole(@PathVariable("email")String personalEmail) {
    	return ResponseEntity.ok(service.consultaRole(personalEmail));
    }
    
    @GetMapping("/teste")
    public ResponseEntity<List<DataEntity>> verUsers(){
        return ResponseEntity.ok(service.listarTodos());
    }
    
}
