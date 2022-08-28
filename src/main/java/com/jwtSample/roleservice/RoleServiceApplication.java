package com.jwtSample.roleservice;

import com.jwtSample.roleservice.model.Role;
import com.jwtSample.roleservice.model.User;
import com.jwtSample.roleservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class RoleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleServiceApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	//data
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));

			userService.saveUser(new User(null,"Alfika","alfika","aaa",new ArrayList<>()));
			userService.saveUser(new User(null,"Nur","nur","nnn",new ArrayList<>()));
			userService.saveUser(new User(null,"Muis","muis","mmm",new ArrayList<>()));

			userService.addRoleToUser("alfika","ROLE_ADMIN");
			userService.addRoleToUser("alfika","ROLE_MANAGER");
			userService.addRoleToUser("muis","ROLE_MANAGER");
			userService.addRoleToUser("nur","ROLE_USER");
			userService.addRoleToUser("nur","ROLE_ADMIN");
		};
	}

}
