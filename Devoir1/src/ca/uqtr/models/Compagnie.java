package ca.uqtr.models;


import java.util.List;

public class Compagnie {

    private final String name;
    private List<Chauffeur> chauffeurs;
    private List<Limousine> limousines;

    public Compagnie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Chauffeur> getChauffeurs() {
        return chauffeurs;
    }

    public void setChauffeurs(List<Chauffeur> chauffeurs) {
        this.chauffeurs = chauffeurs;
    }

    public List<Limousine> getLimousines() {
        return limousines;
    }

    public void setLimousines(List<Limousine> limousines) {
        this.limousines = limousines;
    }
}
