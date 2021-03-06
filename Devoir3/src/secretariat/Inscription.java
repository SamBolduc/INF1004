/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat;

/**
 * Inscription d'un étudiant à un cours.
 * <p>
 * Notez qu'à la sauvegarde, ce sont les identifiants (sigle, code permanent)
 * qui devraient être enregistrés.
 */
public class Inscription {

    private Cours cours;
    private Etudiant etudiant;

    /*
     * Note: Transient signifie juste que ces éléments ne devraient pas être
     * sérialisés avec l'objet
     *
     * prochainCours : même étudiant, mais prochain cours qui est inscrit
     * prochainEtudiant: même cours, mais prochain étudiant de ce cours
     *
     *
     */
    private transient Inscription prochainCours, prochainEtudiant;

    public Inscription(Cours cours, Etudiant etudiant) {
        this.cours = cours;
        this.etudiant = etudiant;
    }

    public Cours getCours() {
        return cours;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setProchainCours(Inscription prochain) {
        prochainCours = prochain;
    }

    public void setProchainEtudiant(Inscription prochainEtudiant) {
        this.prochainEtudiant = prochainEtudiant;
    }

    public Inscription getProchainCours() {
        return prochainCours;
    }

    public Inscription getProchainEtudiant() {
        return prochainEtudiant;
    }

}
