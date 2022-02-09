package com.uqtr.devoir1.models;

import com.uqtr.devoir1.models.persist.TrajetModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Chauffeur implements Serializable {
    private String identification;
    private String nom;
    private String prenom;
    private int anneeEmbauche;
    private String adresse;
    private List<Trajet> trajets;

    public Chauffeur(String nom, String prenom, int anneeEmbauche, String adresse) {
        this.identification = nom.substring(0, Math.min(3, nom.length())) + prenom.charAt(0) + String.valueOf(anneeEmbauche).substring(2);
        this.nom = nom;
        this.prenom = prenom;
        this.anneeEmbauche = anneeEmbauche;
        this.adresse = adresse;
        this.trajets = new ArrayList<>();
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAnneeEmbauche() {
        return anneeEmbauche;
    }

    public void setAnneeEmbauche(int anneeEmbauche) {
        this.anneeEmbauche = anneeEmbauche;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Trajet> getTrajets() {
        return trajets;
    }

    public void addTrajet(Trajet trajet) {
        this.trajets.add(trajet);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("--Chauffeur--");
        str.append("\nIdentification : ").append(this.identification);
        str.append("\nNom : ").append(this.nom);
        str.append("\nPrenom : ").append(this.prenom);
        str.append("\nAnnée d'embauche : ").append(this.anneeEmbauche);
        str.append("\nAdresse : ").append(this.adresse);
        str.append("\nTragets : ");
        this.trajets.forEach(t -> str.append(t.toString()));
        return str.toString();
    }
}
