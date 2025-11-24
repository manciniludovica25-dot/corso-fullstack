package com.example.velocista.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.velocista.model.VelocistaModel;

public interface VelocistaRepository extends JpaRepository<VelocistaModel, Long> {
	
	public List<VelocistaModel> findByEta(Integer eta);
	public List<VelocistaModel> findAllByOrderByNominativoAsc();

}
