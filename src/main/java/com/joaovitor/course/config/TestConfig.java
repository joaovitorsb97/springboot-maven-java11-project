package com.joaovitor.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joaovitor.course.entities.Costumer;
import com.joaovitor.course.repositories.CostumerRepository;

@Profile("test") //same name from application.properties spring.profile.active
@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired //Dependency injection auto
	private CostumerRepository costumerRepository;

	@Override
	public void run(String... args) throws Exception {
		Costumer u1 = new Costumer(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Costumer u2 = new Costumer(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		costumerRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
}
