package com.course.course.configuration;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.course.entities.Order;
import com.course.course.entities.User;
import com.course.course.entities.enums.OrderStatus;
import com.course.course.repositories.OrderRepository;
import com.course.course.repositories.UserRepository;

//Para fazer o seeding do DB
@Configuration
@Profile("test") //Tem que ser igual ao nome usado no spring.profiles.active=test dentro do application.properties
public class TestConfig implements CommandLineRunner{

	@Autowired //Para associar uma depedência com o repository criado
	private UserRepository userRepository;

	@Autowired //Para associar uma depedência com o repository criado
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2024-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2024-07-21T03:42:10Z"), OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2024-07-22T15:21:22Z"), OrderStatus.PAID, u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}	
}
