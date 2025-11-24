package com.example.abbigliamento.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PANTALONE")
public class Pantalone extends Abito {

    public Pantalone() {
        super();
    }

    public Pantalone(String tipo, String marca, String taglia, double prezzo) {
        super(tipo, marca, taglia, prezzo);
    }
}
