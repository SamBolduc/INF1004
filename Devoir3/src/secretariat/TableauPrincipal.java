/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat;

import secretariat.io.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
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
        if (instance == null) instance = new TableauPrincipal();
        return instance;
    }

    public TableauPrincipal() {
        this.listeCours = new ArrayList<>();
        this.listeEtudiants = new ArrayList<>();
    }

    public void load() {
        this.listeEtudiants = new ArrayList<>(Util.getEtudiantReader().read(new File("Etudiants.txt")));
        this.listeCours = new ArrayList<>(Util.getCoursReader().read(new File("Cours.txt")));

        new Util().getInscriptionReader(this).read(new File("Inscriptions.txt"));
    }

    public void save() {
        Util.getEtudiantWriter().write(this.listeEtudiants, new File("Etudiants.txt"));
        Util.getCoursWriter().write(this.listeCours, new File("Cours.txt"));

        List<Inscription> inscriptions = new ArrayList<>();
        for (Cours cours : this.listeCours) {
            Iterator<Inscription> it = cours.iterator();
            while (it.hasNext()) inscriptions.add(it.next());
        }
        new Util().getInscriptionWriter().write(inscriptions, new File("Inscriptions.txt"));
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
        if (cours == null || etud == null) return false;

        Etudiant existentStudent = this.listeEtudiants.stream().filter(x -> x.equals(etud)).findFirst().orElse(null);
        Cours existentCourse = this.listeCours.stream().filter(x -> x.equals(cours)).findFirst().orElse(null);
        if (existentStudent == null || existentCourse == null) return false;

        List<Inscription> inscriptions = new ArrayList<>();
        Inscription newInscription = new Inscription(existentCourse, existentStudent);

        if (existentCourse.getMaxEtudiants() == existentCourse.getNbEtudiant())
            return false;

        // Course's inscription
        Iterator<Inscription> it = existentCourse.iterator();
        while (it.hasNext()) {// get last inscription
            Inscription insc = it.next();
            inscriptions.add(insc);
            if (insc.getEtudiant().getCodePermanent().equalsIgnoreCase(etud.getCodePermanent()))
                return false;
        }

        if (inscriptions.size() > 0) inscriptions.get(inscriptions.size() - 1).setProchainEtudiant(newInscription);
        inscriptions.add(newInscription);
        existentCourse.setInscriptions(inscriptions);

        // Student's inscription
        inscriptions = new ArrayList<>();
        it = existentStudent.iterator();
        while (it.hasNext()) // get last inscription
            inscriptions.add(it.next());
        if (inscriptions.size() > 0) inscriptions.get(inscriptions.size() - 1).setProchainCours(newInscription);
        inscriptions.add(newInscription);
        existentStudent.setInscriptions(inscriptions);

        return true;
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
        if (cours == null || etud == null) return false;

        Etudiant existentStudent = this.listeEtudiants.stream().filter(x -> x.equals(etud)).findFirst().orElse(null);
        Cours existentCourse = this.listeCours.stream().filter(x -> x.equals(cours)).findFirst().orElse(null);
        if (existentStudent == null || existentCourse == null) return false;

        Inscription lastInscription = null;
        Iterator<Inscription> iterator = existentCourse.iterator();
        while (iterator.hasNext()) {
            Inscription inscription = iterator.next();
            if (inscription.getCours().equals(existentCourse) && inscription.getEtudiant().equals(existentStudent)) {
                if (lastInscription != null && iterator.hasNext())
                    lastInscription.setProchainEtudiant(iterator.next().getProchainEtudiant());
                iterator.remove();
            }
            lastInscription = inscription;
        }

        lastInscription = null;
        iterator = existentStudent.iterator();
        while (iterator.hasNext()) {
            Inscription inscription = iterator.next();
            if (inscription.getCours().equals(existentCourse) && inscription.getEtudiant().equals(existentStudent)) {
                if (lastInscription != null && iterator.hasNext())
                    lastInscription.setProchainCours(iterator.next().getProchainCours());
                iterator.remove();
                return true;
            }
            lastInscription = inscription;
        }

        return false;
    }

    /**
     * Réalise la désinscription d'un étudiant à un cours.
     *
     * @param sigle         Sigle du cours
     * @param codePermanent Code permanent de l'étudiant
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
