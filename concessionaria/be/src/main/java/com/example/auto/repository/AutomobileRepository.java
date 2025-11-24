package com.example.auto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auto.model.Automobile;

public interface AutomobileRepository extends JpaRepository<Automobile, Long>{
	
	List<Automobile>findByMarca(String marca);

}
