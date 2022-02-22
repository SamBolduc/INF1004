package ca.uqtr.menu.tasks;

public class QuitTask extends AbstractTask {
    @Override
    public void execute() {
        System.out.println("Beeeeep Boooop...");
        System.exit(-1);
    }
}
