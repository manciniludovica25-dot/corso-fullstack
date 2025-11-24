package com.example.abbigliamento.model;

import jakarta.persistence.*;

@Entity
@Table(name = "abito")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public abstract class Abito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private String tipo;

    private String marca;
    private String taglia;
    private double prezzo;

    protected Abito() {
    }

    protected Abito(String tipo, String marca, String taglia, double prezzo) {
        this.tipo = tipo;
        this.marca = marca;
        this.taglia = taglia;
        this.prezzo = prezzo;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getTaglia() {
        return taglia;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTaglia(String taglia) {
        this.taglia = taglia;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
