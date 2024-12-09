package com.pawpengaga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pawpengaga.modelo.Usuario;
import com.pawpengaga.servicios.UserService;

@SpringBootApplication	
public class JdbcUsuariosApplication {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(JdbcUsuariosApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	Usuario u = new Usuario("12", "Rhea", "rhea@mail.com", "1234", "awaken");
	// 	userService.createUser(u);
	// }

}
