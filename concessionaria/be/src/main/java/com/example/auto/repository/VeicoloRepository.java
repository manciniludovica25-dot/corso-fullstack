package com.example.auto.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auto.model.Veicolo;

public interface VeicoloRepository extends JpaRepository<Veicolo, Long> {

	List<Veicolo> findByMarca(String marca);

	List<Veicolo> findByMarcaIgnoreCase(String marca);
}
