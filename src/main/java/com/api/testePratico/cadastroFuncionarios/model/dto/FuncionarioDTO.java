package com.api.testePratico.cadastroFuncionarios.model.dto;

import com.api.testePratico.cadastroFuncionarios.model.Funcionario;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class FuncionarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private String sexo;
    private Integer idade;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;

    public FuncionarioDTO(){

    }

    public FuncionarioDTO(Funcionario funcionario){
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.sexo = funcionario.getSexo();
        this.idade = funcionario.getIdade();
        this.cep = funcionario.getCep();
        this.endereco = funcionario.getEndereco();
        this.bairro = funcionario.getBairro();
        this.cidade = funcionario.getCidade();
        this.estado = funcionario.getEstado();
    }
}
