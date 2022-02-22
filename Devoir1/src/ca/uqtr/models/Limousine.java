package ca.uqtr.models;

public class Limousine {
    private String immatriculation;
    private int capaciteReservoir;
    private String couleur;

    public Limousine(String immatriculation, int capaciteReservoir, String couleur) {
        this.immatriculation = immatriculation;
        this.capaciteReservoir = capaciteReservoir;
        this.couleur = couleur;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getCapaciteReservoir() {
        return capaciteReservoir;
    }

    public void setCapaciteReservoir(int capaciteReservoir) {
        this.capaciteReservoir = capaciteReservoir;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("--Limousine--");
        str.append("\nImmatriculation : ").append(this.immatriculation);
        str.append("\nCapacité du réservoir : ").append(this.capaciteReservoir);
        str.append("\nCouleur : ").append(this.couleur);
        return str.toString();
    }
}
