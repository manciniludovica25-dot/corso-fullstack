package com.example.ristorante.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "piatto")
@JsonIdentityInfo (generator = ObjectIdGenerators.PropertyGenerator.class,
property ="id")
public class Piatto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String categoria;

    private Double prezzo;

    private String immagine;

    // LISTA INGREDIENTI come relazione ManyToMany
    @ManyToMany
    @JoinTable(
        name = "piatto_ingrediente",
        joinColumns = @JoinColumn(name = "piatto_id"),
        inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<Ingrediente> ingredienti = new ArrayList<>();
    // --------------------------^
    // Questo nome DEVE coincidere con mappedBy="ingredienti" in Ingrediente

    public Piatto() {
    }

    public Piatto(String nome, String categoria, Double prezzo, String immagine) {
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
        this.immagine = immagine;
    }

    // getter/setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public List<Ingrediente> getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(List<Ingrediente> ingredienti) {
        this.ingredienti = ingredienti;
    }
}
