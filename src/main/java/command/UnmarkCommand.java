package command;

import ui.Lmbd;

public class UnmarkCommand extends Command {
    public UnmarkCommand() {
        super("unmark", 1, "Unmarks the task associated with the number as done");
    }

    @Override
    String run(Lmbd lmbd, String[] args) {
        int id = Integer.valueOf(args[0]) - 1;
        if (id < 0 || id >= lmbd.tasks.getTaskSize()) {
            return "Invalid id";
        }

        boolean success = lmbd.tasks.mark(id, false);

        if (!success) {
            return String.format("Task \"%s\" is not done, unable to unmark", lmbd.tasks.getTaskTitle(id));
        }

        return String.format("The task \"%s\" has been unmarked.", lmbd.tasks.getTaskTitle(id));
    }
}
