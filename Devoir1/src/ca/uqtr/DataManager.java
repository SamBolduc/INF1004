package ca.uqtr;

import ca.uqtr.exceptions.NoPersistentDataException;
import ca.uqtr.models.Chauffeur;
import ca.uqtr.models.Compagnie;
import ca.uqtr.models.Limousine;
import ca.uqtr.models.Trajet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class DataManager {

    private final Compagnie autoDeLuxe;

    private static DataManager instance;

    public static DataManager getInstance() throws NoPersistentDataException {
        if (instance == null)
            throw new NoPersistentDataException();
        return instance;
    }

    public DataManager(String chauffeursPath, String limousinesPath, String trajetsPath) throws FileNotFoundException {
        this.autoDeLuxe = new Compagnie("AutodeLuxe");

        this.loadLimousines(limousinesPath);
        this.loadChauffeurs(chauffeursPath);
        this.loadTrajets(trajetsPath);

        instance = this;
    }

    public Compagnie getAutoDeLuxe() {
        return this.autoDeLuxe;
    }

    public void loadChauffeurs(String filePath) throws FileNotFoundException {
        List<Chauffeur> chauffeurs = new ArrayList<>();

        List<String[]> data = this.getFileData(filePath);
        for (String[] line : data) {
            Chauffeur chauffeur = new Chauffeur(line[0].trim(), line[1].trim(), Integer.parseInt(line[2].trim()), line[3].trim());
            chauffeurs.add(chauffeur);
        }

        this.autoDeLuxe.setChauffeurs(chauffeurs);
    }

    public void loadLimousines(String filePath) throws FileNotFoundException {
        List<Limousine> limousines = new ArrayList<>();

        List<String[]> data = this.getFileData(filePath);
        for (String[] line : data) {
            Limousine limousine = new Limousine(line[0].trim(), Integer.parseInt(line[1].trim()), line[2].trim());
            limousines.add(limousine);
        }

        this.autoDeLuxe.setLimousines(limousines);
    }

    public void loadTrajets(String filePath) throws FileNotFoundException {
        List<Trajet> trajets = new ArrayList<>();

        List<String[]> data = this.getFileData(filePath);
        for (String[] line : data) {
            Trajet trajet = new Trajet(line[1], line[2], Integer.parseInt(line[3].trim()), Integer.parseInt(line[4].trim()), this.findLimousineByImmatriculation(line[5].trim()).orElse(null));
            trajets.add(trajet);
            this.findChauffeurById(line[0].trim()).ifPresent(x -> x.addTrajet(trajet));
        }
    }

    public Optional<Chauffeur> findChauffeurById(String id) {
        return this.autoDeLuxe
                .getChauffeurs()
                .stream()
                .filter(x -> x.getIdentification().equals(id))
                .findFirst();
    }

    public Optional<Limousine> findLimousineByImmatriculation(String immatriculation) {
        return this.autoDeLuxe
                .getLimousines()
                .stream()
                .filter(x -> x.getImmatriculation().equals(immatriculation))
                .findFirst();
    }

    private List<String[]> getFileData(String filePath) {
        Path path = Paths.get(filePath);
        List<String[]> data = new ArrayList<>();

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                if (!line.trim().equals(""))
                    data.add(line.split("\t"));
            });
        } catch (IOException e) {
            System.err.println("Il n'a pas été possible de lire le fichier " + filePath + ". Erreur : " + e.getMessage());
        }

        return data;
    }

}
