package com.example.auto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("MOTOCICLETTA")
public class Motocicletta extends Veicolo {

    public Motocicletta() {
        super();
    }

    public Motocicletta(String modello,
                        String marca,
                        String codiceImmatricolazione,
                        LocalDate dataImmatricolazione,
                        double prezzo) {
        super(modello, marca, codiceImmatricolazione, dataImmatricolazione, prezzo);
    }
}
