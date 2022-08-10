package com.joaovitor.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaovitor.course.entities.Costumer;
import com.joaovitor.course.repositories.CostumerRepository;
import com.joaovitor.course.services.exceptions.ResourceNotFoundException;

@Service
public class CostumerService {
	
	@Autowired
	private CostumerRepository costumerRepository;
	
	public List<Costumer> findAll(){
		return costumerRepository.findAll();
	}	
	
	public Costumer findById(Long id) {
		Optional<Costumer> obj = costumerRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Costumer insert(Costumer costumer) {
		return costumerRepository.save(costumer);
	}
	
	public void delete(Long id) {
		costumerRepository.deleteById(id);
	}
	
	public Costumer update(Long id, Costumer costumer) {
		Costumer entity = costumerRepository.getReferenceById(id);
		updateData(entity, costumer);
		return costumerRepository.save(entity);
	}

	private void updateData(Costumer entity, Costumer costumer) {
		entity.setName(costumer.getName());
		entity.setEmail(costumer.getEmail());
		entity.setPhone(costumer.getPhone());
		
	}
	
}
