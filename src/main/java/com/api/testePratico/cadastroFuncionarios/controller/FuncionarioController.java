package com.api.testePratico.cadastroFuncionarios.controller;

import com.api.testePratico.cadastroFuncionarios.model.Funcionario;
import com.api.testePratico.cadastroFuncionarios.model.dto.FuncionarioDTO;
import com.api.testePratico.cadastroFuncionarios.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping(value = "/cadastrar", produces = "application/json")
    public ResponseEntity<FuncionarioDTO> cadastrar(@RequestBody FuncionarioDTO funcionarioDTORecebido) throws IOException {
        return new ResponseEntity<FuncionarioDTO>(funcionarioService.cadastrar(funcionarioDTORecebido), HttpStatus.CREATED);
    }

    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<Page<Funcionario>> getFindAllFuncionarios(Pageable pageable){
        return new ResponseEntity<Page<Funcionario>>(funcionarioService.getFindAllFuncionarios(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<FuncionarioDTO> getFuncionario(@PathVariable Long id){
        return new ResponseEntity<FuncionarioDTO>(funcionarioService.getFuncionarioId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getFuncionarioCep", produces = "application/json")
    public ResponseEntity<FuncionarioDTO> getFuncionarioCep(@RequestParam("cep") String cep){
        return new ResponseEntity<FuncionarioDTO>(funcionarioService.getFuncionarioCep(cep), HttpStatus.OK);
    }

    @PutMapping(value= "/{id}", produces = "application/json")
    public ResponseEntity<FuncionarioDTO> atualizar (@RequestBody FuncionarioDTO funcionarioRecebido, @PathVariable Long id) throws IOException {
        funcionarioRecebido.setId(id);
        return new ResponseEntity<FuncionarioDTO>(funcionarioService.putFuncionario(funcionarioRecebido), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
