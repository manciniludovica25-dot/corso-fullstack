package com.example.auto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.auto.model.Veicolo;
import com.example.auto.service.ConcessionarioService;

import java.util.List;

@RestController
@RequestMapping("/api/veicoli")
@CrossOrigin(origins = "http://localhost:4200")
public class VeicoloController {

	@Autowired
    private  ConcessionarioService service;

    
    // --- Operazioni generali ---

    @GetMapping
    public List<Veicolo> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veicolo> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Veicolo creaVeicolo(@RequestBody Veicolo veicolo) {
        return service.save(veicolo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    	service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // --- Metodi richiesti dall'esercizio ---

    @GetMapping("/prezzo-medio")
    public double getPrezzoMedio() {
        return service.calcolaPrezzoMedio();
    }

    @GetMapping("/meno-caro")
    public ResponseEntity<Veicolo> getMenoCaro() {
        Veicolo v = service.trovaMenoCaro();
        if (v == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(v);
    }

    @GetMapping("/prezzo-medio/marca/{marca}")
    public double getPrezzoMedioPerMarca(@PathVariable String marca) {
        return service.calcolaPrezzoMedioPerMarca(marca);
    }

    // per Angular: veicoli di una certa categoria (automobile, motocicletta, furgone)
    @GetMapping("/categoria/{categoria}")
    public List<Veicolo> getByCategoria(@PathVariable String categoria) {
        return service.getByCategoria(categoria);
    }
}
