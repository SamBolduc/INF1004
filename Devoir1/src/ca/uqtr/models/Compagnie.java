/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 * Contenu: Modèle d'une compagnie.
 */

package ca.uqtr.models;


import java.util.List;

public class Compagnie {

    private final String name;
    private List<Chauffeur> chauffeurs;
    private List<Limousine> limousines;
    private List<Trajet> trajets;

    public Compagnie(String name) {
        this.name = name;
    }

    public List<Chauffeur> getChauffeurs() {
        return chauffeurs;
    }

    public void setChauffeurs(List<Chauffeur> chauffeurs) {
        this.chauffeurs = chauffeurs;
    }

    public List<Limousine> getLimousines() {
        return limousines;
    }

    public void setLimousines(List<Limousine> limousines) {
        this.limousines = limousines;
    }

    public List<Trajet> getTrajets() {
        return trajets;
    }

    public void setTrajets(List<Trajet> trajets) {
        this.trajets = trajets;
    }
}
