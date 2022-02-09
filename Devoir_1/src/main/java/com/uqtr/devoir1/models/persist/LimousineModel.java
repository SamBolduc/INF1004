package com.uqtr.devoir1.models.persist;

import java.io.Serializable;

// Ici, on retire les warning comme quoi les variables ne sont pas utilisées, car elles sont initialisées dynamiquement grâce au polymorphisme.
@SuppressWarnings("unused")
public class LimousineModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String immatriculation;
    private int capaciteReservoir;
    private String couleur;

    public String getImmatriculation() {
        return immatriculation;
    }

    public int getCapaciteReservoir() {
        return capaciteReservoir;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void setCapaciteReservoir(int capaciteReservoir) {
        this.capaciteReservoir = capaciteReservoir;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
