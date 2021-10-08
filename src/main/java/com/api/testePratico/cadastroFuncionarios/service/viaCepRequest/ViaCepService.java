package com.api.testePratico.cadastroFuncionarios.service.viaCepRequest;

import com.api.testePratico.cadastroFuncionarios.service.viaCepRequest.model.EnderecoViaCepModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ViaCepService {

    @GET("ws/{cep}/json/")
    Call<EnderecoViaCepModel> getEnderecoViaCep(@Path("cep") String cep);
}
