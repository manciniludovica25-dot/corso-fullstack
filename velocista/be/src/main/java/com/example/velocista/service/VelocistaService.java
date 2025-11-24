package com.example.velocista.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.velocista.model.VelocistaModel;
import com.example.velocista.repository.VelocistaRepository;

@Service
public class VelocistaService {
	
	@Autowired
	private VelocistaRepository repo;
	
	public VelocistaModel create(VelocistaModel velocista) {
	    if (velocista.getEta() <= 35) {
	        return repo.save(velocista);
	    } else {
	        throw new IllegalArgumentException("Età non valida: deve essere <= 35");
	    }
	}
	
	public List<VelocistaModel> findAll(){
		return repo.findAllByOrderByNominativoAsc();
	}
	
	public List<VelocistaModel> findByEta(Integer eta){
		return repo.findByEta(eta);
	}

}
