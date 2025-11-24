package com.example.fastfood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.fastfood.model.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
	
	@Query("SELECT p FROM Prodotto p WHERE p.prezzo >= :minPrice")
	List<Prodotto> findProdottiByMinPrice(@Param("minPrice") Double minPrice);

	List<Prodotto> findByCategoria(String categoria);

}
