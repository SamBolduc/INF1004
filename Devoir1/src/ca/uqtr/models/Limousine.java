/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 * Contenu: Modèle de la limousine.
 */

package ca.uqtr.models;

public class Limousine {

    private final String immatriculation;
    private final int capaciteReservoir;
    private final String couleur;

    public Limousine(String immatriculation, int capaciteReservoir, String couleur) {
        this.immatriculation = immatriculation;
        this.capaciteReservoir = capaciteReservoir;
        this.couleur = couleur;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("--Limousine--");
        str.append("\nImmatriculation : ").append(this.immatriculation);
        str.append("\nCapacité du réservoir : ").append(this.capaciteReservoir);
        str.append("\nCouleur : ").append(this.couleur);
        str.append("\n");
        return str.toString();
    }
}
