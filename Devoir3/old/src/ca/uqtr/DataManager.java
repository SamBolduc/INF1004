/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 * Contenu: Classe servant de manager des données.
 */

package ca.uqtr;

import ca.uqtr.models.Programme;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private final List<Programme> programmes;

    private static DataManager instance;

    public static DataManager getInstance() {
        return instance;
    }

    public DataManager() {
        this.programmes = new ArrayList<>();

        instance = this;
    }

    //    public void loadTrajets(String filePath) {
    //        List<Trajet> trajets = new ArrayList<>();
    //
    //        List<String[]> data = this.getFileData(filePath);
    //        for (String[] line : data) {
    //            Trajet trajet = new Trajet(line[1], line[2], Integer.parseInt(line[3].trim()), Integer.parseInt(line[4].trim()), this.findLimousineByImmatriculation(line[5].trim()).orElse(null));
    //            trajets.add(trajet);
    //            this.findChauffeurById(line[0].trim()).ifPresent(x -> x.addTrajet(trajet));
    //        }
    //
    //        this.programmes.setTrajets(trajets);
    //    }

}
