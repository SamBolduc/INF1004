package ca.uqtr.models;

import java.util.ArrayList;
import java.util.List;

public class Cours {

    private String sigle;
    private String nom;
    private int maxEtudiants;
    private List<String> prerequis; // Sigles de cours
    private List<String> etudiantsInscrits; // Code permanents

    public Cours(String sigle, String nom, int maxEtudiants) {
        this.sigle = sigle;
        this.nom = nom;
        this.maxEtudiants = maxEtudiants;

        this.prerequis = new ArrayList<>();
        this.etudiantsInscrits = new ArrayList<>();
    }

    public int getCountEtudiants() {
        return this.etudiantsInscrits.size();
    }

    public void addPrerequis(String sigle) {
        // Verify if class exists (DataManager.getInstance().getCoursBySigle(sigle) != null)
        // Throw CoursNotFoundException
        // Ajouter dans la liste des prérequis
    }

    public void addEtudiant(String codePermanent) {
        // Verify if class exists (DataManager.getInstance().getEtudiantByCodePermanent(codePermanent) != null)
        // Throw EtudiantNotFoundException
        // Ajouter dans la liste des étudiants inscrits
    }

    public List<Cours> getPrerequis() {
        return null;
//        return prerequis.stream().map();
    }

    public void setPrerequis(List<String> prerequis) {
        this.prerequis = prerequis;
    }
}
