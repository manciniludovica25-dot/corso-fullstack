package com.example.auto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auto.model.Motocicletta;

public interface MotociclettaRepository extends JpaRepository<Motocicletta, Long>  {
	List<Motocicletta>findByMarca(String marca);

}
