package com.api.testePratico.cadastroFuncionarios.service.viaCepRequest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseURL {
    public Retrofit base_url() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://viacep.com.br/").
                addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
