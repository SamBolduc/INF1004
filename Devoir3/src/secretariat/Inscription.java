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

}
