package com.example.fastfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.fastfood.model.Prodotto;
import com.example.fastfood.service.ProdottoService;


@RestController
@RequestMapping("/api/prodotto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdottoController {

	@Autowired
	private ProdottoService service;

	@GetMapping
	public List<Prodotto> getAll() {
		return service.getAll();
	}

	@GetMapping("/categoria/{categoria}")
	public List<Prodotto> getCategoria(@PathVariable String categoria) {
		return service.getByCategoria(categoria);
	}

	@GetMapping("/byCategoria")
	public List<Prodotto> getByCategoria(@RequestParam String categoria) {
		return service.getByCategoria(categoria);
	}

	@GetMapping("/economico")
	public String getEconomico() {
		Prodotto economico = service.getPriceEco();
		return( "Il più economico è " + economico.getNome() + " al prezzo di " + economico.getPrezzo() + " €");
	}

	@GetMapping("/caro")
	public String getEsoso() {
		Prodotto esoso = service.getPriceEso();
		return ("il piu costoso è " + esoso.getNome() + " al prezzo di " + esoso.getPrezzo() + " €");
	}

	@GetMapping("/media")
	public String getMedia() {
		Double media = service.getMedia();
		return ("la media è " + media);
	}

}
