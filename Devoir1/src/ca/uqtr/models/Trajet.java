package ca.uqtr.models;


public class Trajet {
    private String villeDepart;
    private String villeArrivee;
    private int kmDepart;
    private int kmArrivee;
    private Limousine limousine;

    public Trajet(String villeDepart, String villeArrivee, int kmDepart, int kmArrivee, Limousine limousine) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.kmDepart = kmDepart;
        this.kmArrivee = kmArrivee;
        this.limousine = limousine;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public int getKmDepart() {
        return kmDepart;
    }

    public void setKmDepart(int kmDepart) {
        this.kmDepart = kmDepart;
    }

    public int getKmArrivee() {
        return kmArrivee;
    }

    public void setKmArrivee(int kmArrivee) {
        this.kmArrivee = kmArrivee;
    }

    public Limousine getLimousine() {
        return limousine;
    }

    public void setLimousine(Limousine limousine) {
        this.limousine = limousine;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("--Trajet--");
        str.append("\nVille de départ : ").append(this.villeDepart);
        str.append("\nVille d'arrivée : ").append(this.villeArrivee);
        str.append("\nKM de départ : ").append(this.kmDepart);
        str.append("\nKM d'arrivée : ").append(this.kmArrivee);
        str.append("\nLimousine : ").append(this.limousine.toString());
        return str.toString();
    }
}
