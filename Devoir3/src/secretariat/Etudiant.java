package secretariat;

import secretariat.exception.BadInstanciationException;

import java.util.Iterator;
import java.util.Objects;

public class Etudiant {

    private String codePermanent, nom, prenom;
    private int noProgramme, credits;
    private double moyenneCumul;

    private transient int nombreCours;

    // Représente la liste des inscriptions
    /**
     * On doit pouvoir obtenir un {@link Iterator} qui permet de parcourir la
     * liste des inscriptions de l'étudiant.
     * Indice : vous pouvez créer une classe qui implémente l'interface Iterable
     */
    private transient Iterable<Inscription> inscriptions;

    public Etudiant(String codePermanent, String nom, String prenom, int noProgramme, int credits) {
        super();
        this.codePermanent = codePermanent;
        this.nom = nom;
        this.prenom = prenom;
        this.noProgramme = noProgramme;
        this.credits = credits;
        this.moyenneCumul = 0;

        valideEtat();
    }

    /**
     * Valide la consistance des entrées. Le cas échéant, lance une
     * {@link BadInstanciationException}.
     *
     * <p>
     * <p>
     * TODO - À vous de l'implémenter ( <i>indice</i>: vous pouvez vous inspirer de
     * celle présente dans {@link Cours})
     */
    private void valideEtat() {
        if (this.codePermanent == null || this.codePermanent.isEmpty())
            throw new BadInstanciationException("codePermanent null ou vide");
        if (this.nom == null || this.nom.isEmpty()) throw new BadInstanciationException("nom null ou vide");
        if (this.prenom == null || this.prenom.isEmpty()) throw new BadInstanciationException("prenom null ou vide");

    }

    public double getMoyenneCumul() {
        return moyenneCumul;
    }

    public String getCodePermanent() {
        return codePermanent;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNoProgramme() {
        return noProgramme;
    }

    public int getCredits() {
        return credits;
    }

    public int getNombreCours() {
        return nombreCours;
    }

    /**
     * TODO Doit retourner un <b>nouvel</b> {@link Iterator} d'inscription
     * permettant de parcourir la list des inscriptions.
     *
     * @return
     */
    public Iterator<Inscription> iterator() {
        return this.inscriptions.iterator();
    }

    public void setMoyenneCumul(double moyenneCumul) {
        this.moyenneCumul = moyenneCumul;
    }

    public void setNoProgramme(int noProgramme) {
        this.noProgramme = noProgramme;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Etudiant)) return false;
        if (other == this) return true;

        Etudiant etudiant = (Etudiant) other;
        return this.getCodePermanent().equals(etudiant.getCodePermanent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.codePermanent);
    }

}
