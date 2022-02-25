package ca.uqtr.models;

public class Trajet {

    private final String villeDepart;
    private final String villeArrivee;
    private final int kmDepart;
    private final int kmArrivee;
    private final Limousine limousine;

    public Trajet(String villeDepart, String villeArrivee, int kmDepart, int kmArrivee, Limousine limousine) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.kmDepart = kmDepart;
        this.kmArrivee = kmArrivee;
        this.limousine = limousine;
    }
    
    public Limousine getLimousine() {
        return limousine;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("--Trajet--");
        str.append("\nVille de départ : ").append(this.villeDepart);
        str.append("\nVille d'arrivée : ").append(this.villeArrivee);
        str.append("\nKM de départ : ").append(this.kmDepart);
        str.append("\nKM d'arrivée : ").append(this.kmArrivee);
        str.append("\nLimousine utilis� : ");
        str.append("\n").append(this.limousine.toString());
        str.append("\n");
        return str.toString();
    }
}





