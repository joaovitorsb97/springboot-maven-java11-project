package com.joaovitor.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joaovitor.course.entities.Costumer;
import com.joaovitor.course.entities.Order;
import com.joaovitor.course.repositories.CostumerRepository;
import com.joaovitor.course.repositories.OrderRepository;

@Profile("test") //same name from application.properties spring.profile.active
@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired //Dependency injection auto
	private CostumerRepository costumerRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		Costumer u1 = new Costumer(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Costumer u2 = new Costumer(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		
		costumerRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	
}
