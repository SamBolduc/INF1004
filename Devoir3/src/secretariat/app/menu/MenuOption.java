/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat.app.menu;

import secretariat.app.menu.tasks.AbstractTask;

public class MenuOption {

    private final int id;
    private final String text;
    private final AbstractTask task;

    public MenuOption(int id, String text, AbstractTask task) {
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
