package secretariat;

import secretariat.exception.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Le tableau principal contient la liste des cours et la liste des étudiants.
 * Comme elle a une visibilité vers les deux listes, c'est cette classe qui aura
 * la responsabilité de gérer l'ajout/retrait d'une inscription.
 */
public class TableauPrincipal {

    private List<Cours> listeCours;
    private List<Etudiant> listeEtudiants;

    private static TableauPrincipal instance;
    public static TableauPrincipal getInstance() {
        if (instance == null)
            instance = new TableauPrincipal();
        return instance;
    }

    public TableauPrincipal() {
        this.listeCours = new ArrayList<>();
        this.listeEtudiants = new ArrayList<>();
    }

    public void ajouterEtudiant(Etudiant etud) {
        Etudiant existent = this.listeEtudiants.stream().filter(x -> x.getCodePermanent().equals(etud.getCodePermanent())).findFirst().orElse(null);
        if (existent != null) throw new IllegalArgumentException("Student already exist");

        this.listeEtudiants.add(etud);
    }

    public void ajouterCours(Cours cours) {
        Cours existent = this.listeCours.stream().filter(x -> x.getSigle().equals(cours.getSigle())).findFirst().orElse(null);
        if (existent != null) throw new IllegalArgumentException("Course already exist");

        this.listeCours.add(cours);
    }

    /**
     * Réalise l'inscription d'un étudiant à un cours. L'étudiant et le cours
     * <b>DOIVENT</b> être présents dans les listes pour pouvoir faire
     * l'inscription.
     *
     * <p>
     *
     * <i>Conseil</i>: Que se passe-t-il si un objet reçu en argument est une copie
     * d'un objet contenu dans une liste (même contenu, instances différentes) ?
     * Gérez cette éventualité.
     *
     * @param cours L'instance du cours
     * @param etud  L'instance de l'étudiant
     * @return si l'inscription a pu être réalisée.
     */
    public boolean inscrire(Cours cours, Etudiant etud) {
        if(cours == null || etud == null) throw new IllegalArgumentException();

        Etudiant existentStudent = this.listeEtudiants.stream().filter(x -> x.equals(etud)).findFirst().orElse(null);
        Cours existentCourse = this.listeCours.stream().filter(x -> x.equals(cours)).findFirst().orElse(null);
        if (existentStudent == null || existentCourse == null) return false;

        //TODO: À completer
        throw new NotImplementedException();
    }

    /**
     * Réalise l'inscription d'un étudiant à un cours. L'étudiant et le cours
     * <b>DOIVENT</b> être présents dans les listes pour pouvoir faire
     * l'inscription.
     *
     * <p>
     *
     * <i>Indice</i>: une fois les objets trouvés dans les listes, vous pouvez
     * déléguer à l'autre méthode.
     *
     * @param sigle         Le sigle du cours
     * @param codePermanent Le code permanent de l'étudiant
     * @return si l'inscription a pu être réalisée.
     */
    public boolean inscrire(String sigle, String codePermanent) {
        Etudiant existentStudent = this.listeEtudiants.stream().filter(x -> x.getCodePermanent().equalsIgnoreCase(codePermanent)).findFirst().orElse(null);
        Cours existentCourse = this.listeCours.stream().filter(x -> x.getSigle().equalsIgnoreCase(sigle)).findFirst().orElse(null);

        return this.inscrire(existentCourse, existentStudent);
    }

    /**
     * Réalise la désinscription d'un étudiant à un cours.
     *
     *
     * <p>
     *
     * <i>Conseil</i>: Que se passe-t-il si un objet reçu en argument est une copie
     * d'un objet contenu dans une liste (même contenu, instances différentes) ?
     * Gérez cette éventualité.
     *
     * @param cours L'instance du cours
     * @param etud  L'instance de l'étudiant
     * @return si l'inscription a pu être réalisée.
     */
    public boolean desinscrire(Cours cours, Etudiant etud) {
        if(cours == null || etud == null) throw new IllegalArgumentException();

        Etudiant existentStudent = this.listeEtudiants.stream().filter(x -> x.equals(etud)).findFirst().orElse(null);
        Cours existentCourse = this.listeCours.stream().filter(x -> x.equals(cours)).findFirst().orElse(null);
        if (existentStudent == null || existentCourse == null) return false;

        //TODO: À completer
        throw new NotImplementedException();
    }

    /**
     * Réalise la désinscription d'un étudiant à un cours.
     *
     * @param sigle Sigle du cours
     * @param codePermanent  Code permanent de l'étudiant
     * @return si l'inscription a pu être réalisée.
     */
    public boolean desinscrire(String sigle, String codePermanent) {
        Etudiant existentStudent = this.listeEtudiants.stream().filter(x -> x.getCodePermanent().equalsIgnoreCase(codePermanent)).findFirst().orElse(null);
        Cours existentCourse = this.listeCours.stream().filter(x -> x.getSigle().equalsIgnoreCase(sigle)).findFirst().orElse(null);

        return this.desinscrire(existentCourse, existentStudent);
    }

    public Iterable<Cours> getCours() {
        return listeCours;
    }

    public Iterable<Etudiant> getEtudiants() {
        return listeEtudiants;
    }
}
