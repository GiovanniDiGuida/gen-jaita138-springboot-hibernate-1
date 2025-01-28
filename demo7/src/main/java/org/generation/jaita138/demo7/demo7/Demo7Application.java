package org.generation.jaita138.demo7.demo7;

import org.generation.jaita138.demo7.demo7.cli.CliManager;
import org.generation.jaita138.demo7.demo7.db.service.NegozioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo7Application implements CommandLineRunner {

	@Autowired
	private NegozioService negozioService;

	public static void main(String[] args) {
		SpringApplication.run(Demo7Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new CliManager(negozioService);
	}

}
