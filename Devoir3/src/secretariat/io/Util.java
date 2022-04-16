package secretariat.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import secretariat.Cours;
import secretariat.Etudiant;
import secretariat.Inscription;
import secretariat.TableauPrincipal;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Pour les modules de lecture-écriture, c'est à vous de les créer. Il
 * <b>faut</b> les référencer ici pour qu'on puisse les tester à la correction.
 */
public class Util {

    public static Reader<Collection<Etudiant>> getEtudiantReader() {
        return file -> {
            Gson gson = new Gson();
            try {
                String content = new String(Files.readAllBytes(file.toPath()));
                return gson.fromJson(content, new TypeToken<ArrayList<Etudiant>>() {}.getType());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new ArrayList<>();
        };
    }

    public static Writer<Iterable<Etudiant>> getEtudiantWriter() {
        return (obj, file) -> {
            Gson gson = new Gson();
            try {
                Files.write(file.toPath(), gson.toJson(obj).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public static Reader<Collection<Cours>> getCoursReader() {
        return file -> {
            Gson gson = new Gson();
            try {
                String content = new String(Files.readAllBytes(file.toPath()));
                return gson.fromJson(content, new TypeToken<ArrayList<Cours>>() {}.getType());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new ArrayList<>();
        };
    }

    public static Writer<Iterable<Cours>> getCoursWriter() {
        return (obj, file) -> {
            Gson gson = new Gson();
            try {
                Files.write(file.toPath(), gson.toJson(obj).getBytes());
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
            Gson gson = new Gson();
            try {
                String content = new String(Files.readAllBytes(file.toPath()));
                return gson.fromJson(content, new TypeToken<ArrayList<Inscription>>() {}.getType());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new ArrayList<>();
        };
    }

    public Writer<Iterable<Inscription>> getInscriptionWriter() {
        return (obj, file) -> {
            Gson gson = new Gson();
            try {
                Files.write(file.toPath(), gson.toJson(obj).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

}
