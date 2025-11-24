package com.example.abbigliamento.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MAGLIONE")
public class Maglione extends Abito {

    public Maglione() {
        super();
    }

    public Maglione(String tipo, String marca, String taglia, double prezzo) {
        super(tipo, marca, taglia, prezzo);
    }
}
