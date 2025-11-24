package com.example.auto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("FURGONE")
public class Furgone extends Veicolo {

    public Furgone() {
        super();
    }

    public Furgone(String modello,
                   String marca,
                   String codiceImmatricolazione,
                   LocalDate dataImmatricolazione,
                   double prezzo) {
        super(modello, marca, codiceImmatricolazione, dataImmatricolazione, prezzo);
    }
}
