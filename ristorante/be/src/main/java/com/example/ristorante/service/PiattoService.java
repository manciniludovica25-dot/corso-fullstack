package com.example.ristorante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ristorante.model.Piatto;
import com.example.ristorante.model.VoceOrdine;
import com.example.ristorante.repository.PiattoRepository;

@Service
public class PiattoService {

	@Autowired
    private PiattoRepository repo;

    
    // --- CRUD sul menu ---

    public List<Piatto> getAll() {
        return repo.findAll();
    }

    public Piatto getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Piatto non trovato con id=" + id));
    }

    public Piatto save(Piatto piatto) {
        return repo.save(piatto);
    }

    public void deleteById(Long id) {
    	repo.deleteById(id);
    }

    // --- Calcolo del prezzo totale del menu consumato ---

    /**
     * @param voci lista di VoceOrdine (piattoId + quantita)
     * @return prezzo totale (Double)
     */
    public double calcolaTotale(List<VoceOrdine> voci) {
        double totale = 0.0;

        if (voci == null) {
            return totale;
        }

        for (VoceOrdine voce : voci) {
            if (voce == null || voce.getPiattoId() == null) {
                continue;
            }

            Piatto piatto = getById(voce.getPiattoId());
            if (piatto.getPrezzo() == null) {
                continue;
            }

            int q = voce.getQuantita();
            if (q <= 0) {
                continue;
            }

            double subtotale = piatto.getPrezzo() * q;
            totale += subtotale;
        }

        return totale;
    }
    
	public List<Piatto> getByCategoria(String categoria){
		return repo.findByCategoria(categoria);
	}
}
