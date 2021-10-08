package com.api.testePratico.cadastroFuncionarios.model;

import com.api.testePratico.cadastroFuncionarios.model.dto.FuncionarioDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(of = { "id" })
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(30)")
    private String nome;

    @Column(columnDefinition = "varchar(10)")
    private String sexo;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false, columnDefinition = "varchar(30)")
    private String cep;

    @Column(columnDefinition = "varchar(30)")
    private String endereco;

    @Column(columnDefinition = "varchar(30)")
    private String bairro;

    @Column(columnDefinition = "varchar(30)")
    private String cidade;

    @Column(columnDefinition = "varchar(30)")
    private String estado;

    public Funcionario(){}

    public Funcionario(FuncionarioDTO dto){
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.sexo = dto.getSexo();
        this.idade = dto.getIdade();
        this.cep = dto.getCep();
        this.endereco = dto.getEndereco();
        this.bairro = dto.getBairro();
        this.cidade = dto.getCidade();
        this.estado = dto.getEstado();
    }
}
