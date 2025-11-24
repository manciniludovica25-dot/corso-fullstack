package com.example.ristorante.model;

public class VoceOrdine {

    private Long piattoId;
    private int quantita;

    public VoceOrdine() {
    }

    public VoceOrdine(Long piattoId, int quantita) {
        this.piattoId = piattoId;
        this.quantita = quantita;
    }

    public Long getPiattoId() {
        return piattoId;
    }

    public void setPiattoId(Long piattoId) {
        this.piattoId = piattoId;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}