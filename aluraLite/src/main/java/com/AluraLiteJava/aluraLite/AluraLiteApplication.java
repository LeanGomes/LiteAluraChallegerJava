package com.AluraLiteJava.aluraLite;

import com.AluraLiteJava.aluraLite.principal.Principal;
import com.AluraLiteJava.aluraLite.repository.AutorRepository;
import com.AluraLiteJava.aluraLite.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraLiteApplication implements CommandLineRunner {

	@Autowired
	LivroRepository livroRepository;

	@Autowired
	AutorRepository autorRepository;

	@Autowired
	private Principal principal;

	public static void main(String[] args) {
		SpringApplication.run(AluraLiteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		principal.exibirMenu();

	}
}
