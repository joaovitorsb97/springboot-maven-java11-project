package com.joaovitor.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaovitor.course.entities.Costumer;
import com.joaovitor.course.repositories.CostumerRepository;

@Service
public class CostumerService {
	
	@Autowired
	private CostumerRepository costumerRepository;
	
	public List<Costumer> findAll(){
		return costumerRepository.findAll();
	}	
	
	public Costumer findById(Long id) {
		Optional<Costumer> obj = costumerRepository.findById(id);
		return obj.get();
	}
	
	public Costumer insert(Costumer costumer) {
		return costumerRepository.save(costumer);
	}
	
}
