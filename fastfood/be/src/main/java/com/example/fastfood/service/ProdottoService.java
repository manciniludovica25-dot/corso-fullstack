package com.example.fastfood.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fastfood.model.Prodotto;
import com.example.fastfood.repository.ProdottoRepository;

@Service
public class ProdottoService {
	
	@Autowired
	private ProdottoRepository prodRepository;
	
	
	public Double getMedia() {
		List<Prodotto> prodotti = prodRepository.findAll();
		Double prezzoMedio = prodotti.stream().mapToDouble(Prodotto::getPrezzo).average().orElse(0.0);

		return prezzoMedio;
	}
	
	  public Prodotto getPriceEco() {
	        return prodRepository.findAll()
	                .stream()
	                .min(Comparator.comparing(Prodotto::getPrezzo))
	                .orElse(null); 
	    }
	
	  public Prodotto getPriceEso() {
	        return prodRepository.findAll()
	                .stream()
	                .max(Comparator.comparing(Prodotto::getPrezzo))
	                .orElse(null); 
	    }
	
	public List<Prodotto> getAll() {
		return prodRepository.findAll();
	}
	
	public List<Prodotto> getByCategoria(String categoria){
		return prodRepository.findByCategoria(categoria);
	}
	
	

}
