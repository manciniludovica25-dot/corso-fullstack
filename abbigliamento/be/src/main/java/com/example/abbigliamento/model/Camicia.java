package com.example.abbigliamento.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CAMICIA")
public class Camicia extends Abito {

    public Camicia() {
        super();
    }

    public Camicia(String tipo, String marca, String taglia, double prezzo) {
        super(tipo, marca, taglia, prezzo);
    }
}
