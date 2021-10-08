package com.api.testePratico.cadastroFuncionarios.service;

import com.api.testePratico.cadastroFuncionarios.model.Funcionario;
import com.api.testePratico.cadastroFuncionarios.model.dto.FuncionarioDTO;
import com.api.testePratico.cadastroFuncionarios.repository.FuncionarioRepository;
import com.api.testePratico.cadastroFuncionarios.service.viaCepRequest.BaseURL;
import com.api.testePratico.cadastroFuncionarios.service.viaCepRequest.ViaCepService;
import com.api.testePratico.cadastroFuncionarios.service.viaCepRequest.model.EnderecoViaCepModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Service
public class FuncionarioService {

    BaseURL baseURL = new BaseURL();

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public FuncionarioDTO cadastrar(FuncionarioDTO funcionarioDTORecebido) throws IOException {
        Funcionario funcionarioRecebido = fromFuncionario(funcionarioDTORecebido);

        if(funcionarioRecebido.getEndereco().equals("")
                && funcionarioRecebido.getBairro().equals("")
                && funcionarioRecebido.getEstado().equals("")
                && funcionarioRecebido.getCidade().equals("")){
            funcionarioRecebido = getEnderecoViaCep(funcionarioRecebido);
        }
        funcionarioRecebido = funcionarioRepository.save(funcionarioRecebido);
        return fromDTO(funcionarioRecebido);
    }

    public FuncionarioDTO putFuncionario(FuncionarioDTO funcionarioRecebido) throws IOException{
        FuncionarioDTO funcionarioCadastrado = getFuncionarioId(funcionarioRecebido.getId());

        if(!funcionarioRecebido.getCep().equals(funcionarioCadastrado.getCep())){
            Funcionario funcionario = getEnderecoViaCep(fromFuncionario(funcionarioRecebido));
            funcionarioRecebido = fromDTO(funcionario);
        }
         Funcionario funcionarioAlterado = funcionarioRepository.save(fromFuncionario(funcionarioRecebido));
        return fromDTO(funcionarioAlterado);
    }

    public Funcionario getEnderecoViaCep(Funcionario funcionarioRecebido) throws IOException{
        ViaCepService viaCepService = baseURL.base_url().create(ViaCepService.class);
        Call<EnderecoViaCepModel> call = viaCepService.getEnderecoViaCep(funcionarioRecebido.getCep());
        Response<EnderecoViaCepModel> response = call.execute();
        EnderecoViaCepModel enderecoViaCepModel = response.body();

        funcionarioRecebido.setEndereco(enderecoViaCepModel.getLogradouro());
        funcionarioRecebido.setBairro(enderecoViaCepModel.getBairro());
        funcionarioRecebido.setCidade(enderecoViaCepModel.getLocalidade());
        funcionarioRecebido.setEstado(enderecoViaCepModel.getUf());
        return funcionarioRecebido;
    }

    public FuncionarioDTO getFuncionarioId(Long id){
        Funcionario funcionarioCadastrado = funcionarioRepository.findById(id).get();
        return fromDTO(funcionarioCadastrado);
    }

    public FuncionarioDTO getFuncionarioCep(String cep){
        Funcionario funcionario = funcionarioRepository.findByCep(cep);
        return fromDTO(funcionario);
    }

    public void deletar(Long id){
        funcionarioRepository.deleteById(id);
    }

    public Page<Funcionario> getFindAllFuncionarios(Pageable pageable){
        return funcionarioRepository.findAll(pageable);
    }

    public Funcionario fromFuncionario(FuncionarioDTO funcionarioDTO){
        return new Funcionario(funcionarioDTO);
    }

    public FuncionarioDTO fromDTO(Funcionario funcionario){
        return new FuncionarioDTO(funcionario);
    }

}
