package com.joaovitor.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaovitor.course.entities.Costumer;

@Repository// <-- It's optional because CostumerRepository is extends JpaRepository<>
public interface CostumerRepository extends JpaRepository<Costumer, Long>{

}
