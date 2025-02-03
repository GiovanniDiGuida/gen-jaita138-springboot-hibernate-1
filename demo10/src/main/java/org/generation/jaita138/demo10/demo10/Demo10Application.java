package org.generation.jaita138.demo10.demo10;

import org.generation.jaita138.demo10.demo10.CliMa.CliManager;
import org.generation.jaita138.demo10.demo10.db.service.CarService;
import org.generation.jaita138.demo10.demo10.db.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo10Application implements CommandLineRunner {

	@Autowired
	private CarService carService;

	@Autowired
	private ParkService parkService;

	public static void main(String[] args) {
		SpringApplication.run(Demo10Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		new CliManager(carService, parkService);
	}

}
