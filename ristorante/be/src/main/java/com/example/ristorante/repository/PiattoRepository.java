package com.example.ristorante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.ristorante.model.Piatto;

public interface PiattoRepository extends JpaRepository<Piatto, Long> {

	
	List<Piatto> findByCategoria(String categoria);
}
