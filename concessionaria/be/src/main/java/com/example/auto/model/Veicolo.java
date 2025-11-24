package com.example.auto.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "veicolo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Veicolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modello;
    private String marca;

    @Column(name = "codice_immatricolazione")
    private String codiceImmatricolazione;

    @Column(name = "data_immatricolazione")
    private LocalDate dataImmatricolazione;

    private double prezzo;

    // costruttore vuoto richiesto da JPA
    protected Veicolo() {
    }

    protected Veicolo(String modello,
                      String marca,
                      String codiceImmatricolazione,
                      LocalDate dataImmatricolazione,
                      double prezzo) {
        this.modello = modello;
        this.marca = marca;
        this.codiceImmatricolazione = codiceImmatricolazione;
        this.dataImmatricolazione = dataImmatricolazione;
        this.prezzo = prezzo;
    }

    public Long getId() {
        return id;
    }

    public String getModello() {
        return modello;
    }

    public String getMarca() {
        return marca;
    }

    public String getCodiceImmatricolazione() {
        return codiceImmatricolazione;
    }

    public LocalDate getDataImmatricolazione() {
        return dataImmatricolazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCodiceImmatricolazione(String codiceImmatricolazione) {
        this.codiceImmatricolazione = codiceImmatricolazione;
    }

    public void setDataImmatricolazione(LocalDate dataImmatricolazione) {
        this.dataImmatricolazione = dataImmatricolazione;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", codiceImmatricolazione='" + codiceImmatricolazione + '\'' +
                ", dataImmatricolazione=" + dataImmatricolazione +
                ", prezzo=" + prezzo +
                '}';
    }
}
