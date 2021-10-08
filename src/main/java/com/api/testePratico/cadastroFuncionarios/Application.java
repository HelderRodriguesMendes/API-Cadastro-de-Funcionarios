package com.api.testePratico.cadastroFuncionarios;

import com.api.testePratico.cadastroFuncionarios.model.Funcionario;
import com.api.testePratico.cadastroFuncionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Funcionario f1 = new Funcionario();
		f1.setNome("Carlos Machado Cunha");
		f1.setSexo("Masculino");
		f1.setIdade(55);
		f1.setCep("76200000");
		f1.setEndereco("Rua Emerindo Pereira");
		f1.setBairro("Centro");
		f1.setCidade("Ipora");
		f1.setEstado("Go");

		funcionarioRepository.save(f1);

		Funcionario f2 = new Funcionario();
		f2.setNome("Lucas Carvalho Silva");
		f2.setSexo("Masculino");
		f2.setIdade(24);
		f2.setCep("76235000");
		f2.setEndereco("Rua Albino Borges");
		f2.setBairro("Caminho das Aguas");
		f2.setCidade("Arenópolis");
		f2.setEstado("GO");

		funcionarioRepository.save(f2);
	}
}
