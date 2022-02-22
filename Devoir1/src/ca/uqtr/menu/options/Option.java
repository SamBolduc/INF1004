package ca.uqtr.menu.options;

import ca.uqtr.menu.tasks.AbstractTask;

public class Option {

    private final int id;
    private final String text;
    private final AbstractTask task;

    public Option(int id, String text, AbstractTask task) {
        this.id = id;
        this.text = text;
        this.task = task;
    }

    public AbstractTask getTask() {
        return task;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return id + " - " + text;
    }
}
