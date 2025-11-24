package com.example.ristorante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ristorante.model.Piatto;
import com.example.ristorante.model.VoceOrdine;
import com.example.ristorante.service.PiattoService;

@RestController
@RequestMapping("/api/piatti")
@CrossOrigin(origins = "http://localhost:4200")
public class PiattoController {

	@Autowired
    private PiattoService service;

  
    // --- Operazioni sul menu di piatti ---

    @GetMapping
    public List<Piatto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Piatto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/new")
    public Piatto creaPiatto(@RequestBody Piatto piatto) {
        return service.save(piatto);
    }

    @PutMapping("/{id}")
    public Piatto aggiornaPiatto(@PathVariable Long id, @RequestBody Piatto piatto) {
        piatto.setId(id);
        return service.save(piatto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaPiatto(@PathVariable Long id) {
    	service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // --- Calcolo del conto del menu consumato ---

    /**
     * Body: lista di voci d'ordine (piattoId + quantita).
     * Ritorna il prezzo totale.
     */
    @PostMapping("/conto")
    public ResponseEntity<Double> calcolaConto(@RequestBody List<VoceOrdine> ordine) {
        double totale = service.calcolaTotale(ordine);
        return ResponseEntity.ok(totale);
    }
    
    //--- Filtra per categoria ---
    
    @GetMapping ("/categoria/{categoria}")
    public List <Piatto> getCategoria (@PathVariable String categoria){
    	return service.getByCategoria(categoria);
    	}
    }


