package com.joaovitor.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaovitor.course.entities.Costumer;

public interface CostumerRepository extends JpaRepository<Costumer, Long>{

}
