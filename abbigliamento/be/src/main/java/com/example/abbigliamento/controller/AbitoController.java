package com.example.abbigliamento.controller;

import com.example.abbigliamento.model.Abito;
import com.example.abbigliamento.service.AbitoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abiti")
@CrossOrigin(origins = "http://localhost:4200") 
public class AbitoController {

    private final AbitoService service;

    public AbitoController(AbitoService service) {
        this.service = service;
    }

    // GET tutti gli abiti
    @GetMapping
    public List<Abito> getAll() {
        return service.getAll();
    }

    // GET per id
    @GetMapping("/{id}")
    public ResponseEntity<Abito> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create
    @PostMapping
    public Abito create(@RequestBody Abito abito) {
        return service.save(abito);
    }

    // PUT update
    @PutMapping("/{id}")
    public ResponseEntity<Abito> update(@PathVariable Long id, @RequestBody Abito abito) {
        try {
            Abito updated = service.update(id, abito);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Abiti per tipo/categoria (es. 'pd' = pantalone donna)
    @GetMapping("/tipo/{tipo}")
    public List<Abito> getByTipo(@PathVariable String tipo) {
        return service.getByTipo(tipo);
    }
}
