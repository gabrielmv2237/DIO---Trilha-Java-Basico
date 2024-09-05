package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.ObservacaoDTO;
import br.com.serratec.entity.ObservacaoEntity;
import br.com.serratec.service.ObservacaoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/observacao")
//@CrossOrigin(originPatterns = "http://34.41.164.86:3005/")
//@CrossOrigin(originPatterns = "*")
public class ObservacaoController {

    @Autowired
    private ObservacaoService service;

    @GetMapping
    public ResponseEntity<List<ObservacaoEntity>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }
    
    @GetMapping("{email}")
    public ResponseEntity<List<ObservacaoDTO>> buscarObsDTO(@PathVariable("email") String email) {
    	return ResponseEntity.ok(service.buscarObsDTO(email));
    }
    
    @PostMapping
    public ResponseEntity<ObservacaoDTO> inserirObservacao(@Valid @RequestBody ObservacaoDTO obs){
        return ResponseEntity.ok(service.postarObservacao(obs));
    }
    
    @PostMapping("{id}")
    public ResponseEntity<ObservacaoDTO> inserirObservacaoId(@PathVariable("id") Long id,@Valid @RequestBody ObservacaoDTO obs){
        return ResponseEntity.ok(service.postarObservacaoId(id,obs));
    }

    @PutMapping("{id}")
    public ResponseEntity<ObservacaoDTO> editarObs(@PathVariable("id") Long id, ObservacaoDTO dto){
    	return ResponseEntity.ok(service.editarObs(id, dto));
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> delObs(@PathVariable("id")Long id) {
    	return ResponseEntity.ok(service.delObs(id));
    }
    
}
