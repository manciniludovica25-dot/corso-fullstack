package com.example.auto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auto.model.Furgone;

public interface FurgoneRepository extends JpaRepository<Furgone, Long> {
	
	List<Furgone> findByMarca(String marca);


}
