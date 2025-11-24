package com.example.abbigliamento.repository;

import com.example.abbigliamento.model.Abito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbitoRepository extends JpaRepository<Abito, Long> {

    List<Abito> findByTipo(String tipo);
}
