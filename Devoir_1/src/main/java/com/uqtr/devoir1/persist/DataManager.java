package com.uqtr.devoir1.persist;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;
import com.uqtr.devoir1.errors.NoPersistentDataException;
import com.uqtr.devoir1.models.Chauffeur;
import com.uqtr.devoir1.models.Limousine;
import com.uqtr.devoir1.models.Trajet;
import com.uqtr.devoir1.models.persist.ChauffeurModel;
import com.uqtr.devoir1.models.persist.LimousineModel;
import com.uqtr.devoir1.models.persist.TrajetModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataManager {

    private List<Chauffeur> chauffeurs;
    private List<Limousine> limousines;
    private List<Trajet> trajets;

    private static DataManager instance;

    public static DataManager getInstance() throws NoPersistentDataException {
        if (instance == null)
            throw new NoPersistentDataException("Aucune donnée a été chargée.");
        return instance;
    }

    public DataManager(String chauffeursPath, String limousinesPath, String trajetsPath) throws FileNotFoundException {
        this.loadLimousines(limousinesPath);
        this.loadChauffeurs(chauffeursPath);
        this.loadTrajets(trajetsPath);

        instance = this;
    }

    // On retire les warnings, dans ce cas seulement, car on utilise un traitement dynamique de conversion de données brutes vers une classe X.
    @SuppressWarnings({"unchecked"})
    public void loadChauffeurs(String filePath) throws FileNotFoundException {
        this.chauffeurs = new ArrayList<>();

        List<ChauffeurModel> list = new CsvToBeanBuilder<ChauffeurModel>(new FileReader(filePath))
                .withSeparator('\t')
                .withIgnoreEmptyLine(true)
                .withMappingStrategy(this.getColumnMapping(ChauffeurModel.class, "nom", "prenom", "anneeEmbauche", "adresse"))
                .build()
                .parse();
        for (ChauffeurModel model : list) {
            Chauffeur chauffeur = new Chauffeur(model.getNom(), model.getPrenom(), model.getAnneeEmbauche(), model.getAdresse());
            this.chauffeurs.add(chauffeur);
        }
    }

    // On retire les warnings, dans ce cas seulement, car on utilise un traitement dynamique de conversion de données brutes vers une classe X.
    @SuppressWarnings({"unchecked"})
    public void loadLimousines(String filePath) throws FileNotFoundException {
        this.limousines = new ArrayList<>();

        List<LimousineModel> list = new CsvToBeanBuilder<LimousineModel>(new FileReader(filePath))
                .withSeparator('\t')
                .withIgnoreEmptyLine(true)
                .withMappingStrategy(this.getColumnMapping(LimousineModel.class, "immatriculation", "capaciteReservoir", "couleur"))
                .build()
                .parse();
        for (LimousineModel model : list) {
            Limousine limousine = new Limousine(model.getImmatriculation(), model.getCapaciteReservoir(), model.getCouleur());
            this.limousines.add(limousine);
        }
    }

    // On retire les warnings, dans ce cas seulement, car on utilise un traitement dynamique de conversion de données brutes vers une classe X.
    @SuppressWarnings({"unchecked"})
    public void loadTrajets(String filePath) throws FileNotFoundException {
        this.trajets = new ArrayList<>();

        List<TrajetModel> list = new CsvToBeanBuilder<TrajetModel>(new FileReader(filePath))
                .withSeparator('\t')
                .withIgnoreEmptyLine(true)
                .withMappingStrategy(this.getColumnMapping(TrajetModel.class, "identification", "villeDepart", "villeArrivee", "kmDepart", "kmArrivee", "limousine"))
                .build()
                .parse();
        for (TrajetModel model : list) {
            Trajet trajet = new Trajet(
                    model.getVilleDepart(),
                    model.getVilleArrivee(),
                    model.getKmDepart(),
                    model.getKmArrivee(),
                    this.findLimousineByImmatriculation(model.getLimousine()).orElse(null));
            this.trajets.add(trajet);

            this.findChauffeurById(model.getIdentification()).ifPresent(x -> x.addTrajet(trajet));
        }
    }

    public List<Chauffeur> getChauffeurs() {
        return chauffeurs;
    }

    public Optional<Chauffeur> findChauffeurById(String id) {
        return this.chauffeurs
                .stream()
                .filter(x -> x.getIdentification().equals(id))
                .findFirst();
    }

    public List<Limousine> getLimousines() {
        return limousines;
    }

    public Optional<Limousine> findLimousineByImmatriculation(String immatriculation) {
        return this.limousines
                .stream()
                .filter(x -> x.getImmatriculation().equals(immatriculation))
                .findFirst();
    }

    public List<Trajet> getTrajets() {
        return trajets;
    }

    // On retire les warnings, dans ce cas seulement, car on utilise un traitement dynamique de conversion de données brutes vers une classe X.
    @SuppressWarnings({"rawtypes", "unchecked"})
    private ColumnPositionMappingStrategy getColumnMapping(Class<?> clazz, String... columns) {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(clazz);
        strategy.setColumnMapping(columns);
        return strategy;
    }

}
