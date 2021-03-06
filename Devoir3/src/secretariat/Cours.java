/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat;

import secretariat.exception.BadInstanciationException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Cours {

    private String sigle, nom;

    private int maxEtudiants;
    private transient int nbEtudiant;
    private List<Cours> prerequis;

    /**
     * Représente la liste des inscriptions
     * {@link Iterator} qui nous permet de parcourir la liste des inscriptions du
     * cours.
     */
    private transient Iterable<Inscription> inscriptions;

    public Cours(String sigle, String nom, int maxEtudiants, List<Cours> prerequis) {
        this.sigle = sigle;
        this.nom = nom;
        this.maxEtudiants = maxEtudiants;
        this.prerequis = prerequis;

        this.nbEtudiant = 0;
        this.inscriptions = new ArrayList<>();

        valideEtat();
    }

    /**
     * Valide la consistance des entrées. Le cas échéant, lance une
     * {@link BadInstanciationException}.
     */
    private void valideEtat() {
        if (sigle == null) throw new BadInstanciationException("Sigle nul");
        if (nom == null) throw new BadInstanciationException("Nom nul");

    }

    public String getSigle() {
        return sigle;
    }

    public String getNom() {
        return nom;
    }

    public int getMaxEtudiants() {
        return maxEtudiants;
    }

    public int getNbEtudiant() {
        return nbEtudiant;
    }

    public List<Cours> getPrerequis() {
        return prerequis;
    }

    public void setPrerequis(List<Cours> prerequis) {
        this.prerequis = prerequis;
    }

    /**
     * TODO Doit retourner un <b>nouvel</b> {@link Iterator} d'inscription
     * permettant de parcourir la list des inscriptions.
     *
     * <p>
     *
     * <i>Indice</i> : Vous pouvez déléguer cette responsabilité à
     * {@link Iterable#iterator()}.
     *
     * @return
     */
    public Iterator<Inscription> iterator() {
        return inscriptions.iterator();
    }

    @Override
    public boolean equals(Object other){
        if (!(other instanceof Cours)) return false;
        if (other == this) return true;

        Cours cours = (Cours) other;
        return this.getSigle().equalsIgnoreCase(cours.getSigle()) && this.getNom().equalsIgnoreCase(cours.getNom()) && this.getMaxEtudiants() == cours.getMaxEtudiants() && this.getPrerequis().equals(cours.getPrerequis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.sigle);
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
        this.nbEtudiant = inscriptions.size();
    }
}
