package com.uqtr.devoir1.models.persist;

// Ici, on retire les warning comme quoi les variables ne sont pas utilisées, car elles sont initialisées dynamiquement grâce au polymorphisme.
@SuppressWarnings("unused")
public class TrajetModel {

    private String identification;
    private String villeDepart;
    private String villeArrivee;
    private int kmDepart;
    private int kmArrivee;
    private String limousine;

    public String getIdentification() {
        return identification;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public int getKmDepart() {
        return kmDepart;
    }

    public int getKmArrivee() {
        return kmArrivee;
    }

    public String getLimousine() {
        return limousine;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public void setKmDepart(int kmDepart) {
        this.kmDepart = kmDepart;
    }

    public void setKmArrivee(int kmArrivee) {
        this.kmArrivee = kmArrivee;
    }

    public void setLimousine(String limousine) {
        this.limousine = limousine;
    }
}
