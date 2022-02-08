package com.uqtr.devoir1.model;

public class Trajet {
    private String villeDepart;
    private String villeArriver;
    private int kmDepart;
    private int kmArriver;
    private Limousine limousine;

    public Trajet(String villeDepart, String villeArriver, int kmDepart, int kmArriver, Limousine limousine) {
        this.villeDepart = villeDepart;
        this.villeArriver = villeArriver;
        this.kmDepart = kmDepart;
        this.kmArriver = kmArriver;
        this.limousine = limousine;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArriver() {
        return villeArriver;
    }

    public void setVilleArriver(String villeArriver) {
        this.villeArriver = villeArriver;
    }

    public int getKmDepart() {
        return kmDepart;
    }

    public void setKmDepart(int kmDepart) {
        this.kmDepart = kmDepart;
    }

    public int getKmArriver() {
        return kmArriver;
    }

    public void setKmArriver(int kmArriver) {
        this.kmArriver = kmArriver;
    }

    public Limousine getLimousine() {
        return limousine;
    }

    public void setLimousine(Limousine limousine) {
        this.limousine = limousine;
    }
}
