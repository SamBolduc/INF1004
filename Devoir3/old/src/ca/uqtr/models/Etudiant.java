package ca.uqtr.models;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {

    private final String codePermanent;
    private final String nom;
    private final String prenom;
    private String noProgramme; // Sigle
    private int nbCredit;
    private float moyenneCumulative;
    private List<String> coursInscrits;

    public Etudiant(String codePermanent, String nom, String prenom) {
        this.codePermanent = codePermanent;
        this.nom = nom;
        this.prenom = prenom;
        this.coursInscrits = new ArrayList<>();
    }

}
