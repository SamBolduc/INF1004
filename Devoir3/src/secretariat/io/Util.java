/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat.io;

import secretariat.Cours;
import secretariat.Etudiant;
import secretariat.Inscription;
import secretariat.TableauPrincipal;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Pour les modules de lecture-écriture, c'est à vous de les créer. Il
 * <b>faut</b> les référencer ici pour qu'on puisse les tester à la correction.
 */
public class Util {

    public static Reader<Collection<Etudiant>> getEtudiantReader() {
        return file -> {
            try {
                List<Etudiant> studentList = new ArrayList<>();

                List<String> lines = Files.readAllLines(file.toPath());
                lines.stream().skip(1).forEach(line -> {
                    String[] arguments = line.split("\t");
                    String codePermanent = arguments[0];
                    String nom = arguments[1];
                    String prenom = arguments[2];
                    int noProgramme = Integer.parseInt(arguments[3]);
                    int credit = Integer.parseInt(arguments[4]);
                    double moyenne = Double.parseDouble(arguments[5]);

                    studentList.add(new Etudiant(codePermanent, nom, prenom, noProgramme, credit, moyenne));
                });

                return studentList;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new ArrayList<>();
        };
    }

    public static Writer<Iterable<Etudiant>> getEtudiantWriter() {
        return (obj, file) -> {
            StringBuilder stringBuilder = new StringBuilder("//Code Permanent\tNom\tPrenom\tNoProgramme\tCrédits\tMoyenne cumulee\n");
            obj.forEach(student -> {
                stringBuilder.append(student.getCodePermanent()).append("\t");
                stringBuilder.append(student.getNom()).append("\t");
                stringBuilder.append(student.getPrenom()).append("\t");
                stringBuilder.append(student.getNoProgramme()).append("\t");
                stringBuilder.append(student.getCredits()).append("\t");
                stringBuilder.append(student.getMoyenneCumul()).append("\t");
                stringBuilder.append("\n");
            });

            try {
                Files.write(file.toPath(), stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public static Reader<Collection<Cours>> getCoursReader() {
        return file -> {
            try {
                List<Cours> courses = new ArrayList<>();

                List<String> lines = Files.readAllLines(file.toPath());
                lines.stream().skip(1).forEach(line -> {
                    String[] arguments = line.split("\t");
                    String sigle = arguments[0];
                    String nom = arguments[1];
                    int maxEtudiant = Integer.parseInt(arguments[2]);

                    List<Cours> requiredCourses = new ArrayList<>();
                    if(arguments.length >= 4) {
                        String[] requiredArr = arguments[3].split(";");
                        List<String> required = Arrays.stream(requiredArr).map(String::trim).collect(Collectors.toList());
                        requiredCourses = required.stream().map(x -> courses.stream().filter(c -> c.getSigle().equalsIgnoreCase(x)).findFirst().orElseThrow(NullPointerException::new)).collect(Collectors.toList());
                    }

                    courses.add(new Cours(sigle, nom, maxEtudiant, requiredCourses));
                });

                return courses;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new ArrayList<>();
        };
    }

    public static Writer<Iterable<Cours>> getCoursWriter() {
        return (obj, file) -> {
            StringBuilder stringBuilder = new StringBuilder("//Sigle\tNom\tnb Etudiants Max\tPrerequis\n");
            obj.forEach(course -> {
                stringBuilder.append(course.getSigle()).append("\t");
                stringBuilder.append(course.getNom()).append("\t");
                stringBuilder.append(course.getMaxEtudiants()).append("\t");
                stringBuilder.append(course.getPrerequis().stream().map(Cours::getSigle).collect(Collectors.joining(" ; "))).append("\t");
                stringBuilder.append("\n");
            });

            try {
                Files.write(file.toPath(), stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    /**
     * Pour la lecture des {@link Inscription Inscriptions}, il faut une visibilité
     * vers les {@link Cours} et {@link Etudiant Étudiants} du
     * {@link TableauPrincipal}.
     *
     * @param tableau
     * @return
     */
    public Reader<Collection<Inscription>> getInscriptionReader(TableauPrincipal tableau) {
        return file -> {
            try {
                List<String> lines = Files.readAllLines(file.toPath());
                lines.stream().skip(1).forEach(line -> {
                    String[] arguments = line.split("\t");
                    String sigle = arguments[0];
                    String codePermanent = arguments[1];
                    boolean succes = tableau.inscrire(sigle, codePermanent);
                    if(!succes)
                        throw new IllegalArgumentException("Failed to create new inscription with given data");
                });

                List<Inscription> inscriptions = new ArrayList<>();
                for (Cours cours : TableauPrincipal.getInstance().getCours()) {
                    Iterator<Inscription> it = cours.iterator();
                    while (it.hasNext())
                        inscriptions.add(it.next());
                }
                return inscriptions;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new ArrayList<>();
        };
    }

    public Writer<Iterable<Inscription>> getInscriptionWriter() {
        return (obj, file) -> {
            StringBuilder stringBuilder = new StringBuilder("//SigleCours\tCP Etudiant\n");
            obj.forEach(inscription -> {
                stringBuilder.append(inscription.getCours().getSigle()).append("\t");
                stringBuilder.append(inscription.getEtudiant().getCodePermanent()).append("\t");
                stringBuilder.append("\n");
            });

            try {
                Files.write(file.toPath(), stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}
