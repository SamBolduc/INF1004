package com.uqtr.devoir1.models.persist;

// Ici, on retire les warning comme quoi les variables ne sont pas utilisées, car elles sont initialisées dynamiquement grâce au polymorphisme.
@SuppressWarnings("unused")
public class ChauffeurModel {

    private String nom;
    private String prenom;
    private int anneeEmbauche;
    private String adresse;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAnneeEmbauche() {
        return anneeEmbauche;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAnneeEmbauche(int anneeEmbauche) {
        this.anneeEmbauche = anneeEmbauche;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
