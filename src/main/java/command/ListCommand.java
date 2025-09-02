package command;

import ui.Lmbd;

public class ListCommand extends Command {
    public ListCommand() {
        super("list", 0, "Displays the list of tasks");
    }

    @Override
    void run(Lmbd lmbd, String[] args) {
        System.out.println(String.format("You have %d tasks:", lmbd.tasks.getTaskSize()));
        for (int i = 0; i < lmbd.tasks.getTaskSize(); i++) {
            System.out.println(String.format("%d. %s", i + 1, lmbd.tasks.getTaskToString(i)));
        }
    }
}
