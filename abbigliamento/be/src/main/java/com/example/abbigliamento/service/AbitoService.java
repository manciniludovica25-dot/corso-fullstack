package com.example.abbigliamento.service;

import com.example.abbigliamento.model.Abito;
import com.example.abbigliamento.repository.AbitoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbitoService {

    private final AbitoRepository repository;

    public AbitoService(AbitoRepository repository) {
        this.repository = repository;
    }

    public List<Abito> getAll() {
        return repository.findAll();
    }

    public Optional<Abito> getById(Long id) {
        return repository.findById(id);
    }

    public Abito save(Abito abito) {
        return repository.save(abito);
    }

    public Abito update(Long id, Abito aggiornato) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setTipo(aggiornato.getTipo());
                    existing.setMarca(aggiornato.getMarca());
                    existing.setTaglia(aggiornato.getTaglia());
                    existing.setPrezzo(aggiornato.getPrezzo());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new IllegalArgumentException("Abito non trovato con id: " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Abito> getByTipo(String tipo) {
        return repository.findByTipo(tipo);
    }
}
