package ca.uqtr.models;

import java.util.List;

public class Programme {

    private final String name;
    private final List<Cours> cours;

    public Programme(String name, List<Cours> cours) {
        this.name = name;
        this.cours = cours;
    }
}
