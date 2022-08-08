package com.joaovitor.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaovitor.course.entities.Costumer;
import com.joaovitor.course.services.CostumerService;

@RestController
@RequestMapping(value = "/costumers")

public class CostumerResource {
	
	@Autowired
	private CostumerService costumerService;
	
	@GetMapping 
	public ResponseEntity<List<Costumer>> findAll(){
		List<Costumer> list = costumerService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Costumer> findById(@PathVariable Long id){
		Costumer obj = costumerService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Costumer> insert(@RequestBody Costumer costumer){
		costumer = costumerService.insert(costumer);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(costumer.getId()).toUri();
		return ResponseEntity.created(uri).body(costumer);
	}
}
