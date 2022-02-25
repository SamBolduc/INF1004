package ca.uqtr.models;

import java.util.ArrayList;
import java.util.List;

public class Chauffeur {
    private final String identification;
    private final String nom;
    private final String prenom;
    private final int anneeEmbauche;
    private final String adresse;
    private final List<Trajet> trajets;

    public Chauffeur(String nom, String prenom, int anneeEmbauche, String adresse) {
        nom = nom.replace("'", "");
        nom = nom.replace("-", "");
        nom = nom.replace(" ", "");

        prenom = prenom.replace("'", "");
        prenom = prenom.replace("-", "");
        prenom = prenom.replace(" ", "");

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
