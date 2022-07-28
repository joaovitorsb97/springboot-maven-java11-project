package com.joaovitor.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaovitor.course.entities.Costumer;

@RestController
@RequestMapping(value = "/costumers")

public class CostumerResource {
	
	@GetMapping 
	public ResponseEntity<Costumer> findAll(){
		Costumer costumer = new Costumer(1L, "Joao", "joao@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(costumer);
	}
}
