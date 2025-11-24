package com.example.auto.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auto.model.Automobile;
import com.example.auto.model.Furgone;
import com.example.auto.model.Motocicletta;
import com.example.auto.model.Veicolo;
import com.example.auto.repository.VeicoloRepository;

@Service
public class ConcessionarioService {

	@Autowired
	private  VeicoloRepository repo;

	// --- CRUD base (se ti servono) ---

	public List<Veicolo> getAll() {
		return repo.findAll();
	}

	public Veicolo save(Veicolo v) {
		return repo.save(v);
	}

	public Optional<Veicolo> getById(Long id) {
		return repo.findById(id);
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	// --- Metodi richiesti dall'esercizio 1) ---

	// prezzo medio di tutti i veicoli
	public double calcolaPrezzoMedio() {
		List<Veicolo> veicoli = repo.findAll();
		return veicoli.stream().mapToDouble(Veicolo::getPrezzo).average().orElse(0.0);
	}

	// veicolo disponibile meno caro
	public Veicolo trovaMenoCaro() {
		return repo.findAll().stream().min(Comparator.comparingDouble(Veicolo::getPrezzo)).orElse(null);
	}

	// prezzo medio tra i veicoli di una certa marca
	public double calcolaPrezzoMedioPerMarca(String marca) {
		List<Veicolo> veicoli = repo.findByMarcaIgnoreCase(marca);
		return veicoli.stream().mapToDouble(Veicolo::getPrezzo).average().orElse(0.0);
	}

	// --- Veicoli di una certa categoria (per Angular) ---

	public List<Veicolo> getByCategoria(String categoria) {
		String cat = categoria.toLowerCase();

		return repo.findAll().stream().filter(v -> switch (cat) {
		case "automobile", "auto" -> v instanceof Automobile;
		case "motocicletta", "moto" -> v instanceof Motocicletta;
		case "furgone", "van" -> v instanceof Furgone;
		default -> false;
		}).toList();
	}
}