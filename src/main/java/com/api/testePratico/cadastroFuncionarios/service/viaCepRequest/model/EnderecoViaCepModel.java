package com.api.testePratico.cadastroFuncionarios.service.viaCepRequest.model;


import java.io.Serializable;

public class EnderecoViaCepModel implements Serializable {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private Integer ibge;
    private Integer gia;
    private Integer ddd;
    private Integer siafi;

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public Integer getGia() {
        return gia;
    }

    public Integer getDdd() {
        return ddd;
    }

    public Integer getSiafi() {
        return siafi;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public void setSiafi(Integer siafi) {
        this.siafi = siafi;
    }
}
