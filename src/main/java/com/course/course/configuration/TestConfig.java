package com.course.course.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.course.entities.User;
import com.course.course.repositories.UserRepository;

//Para fazer o seeding do DB
@Configuration
@Profile("test") //Tem que ser igual ao nome usado no spring.profiles.active=test dentro do application.properties
public class TestConfig implements CommandLineRunner{

	@Autowired //Para associar uma depedência com o repository criado
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}
