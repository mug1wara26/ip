package command;

import ui.Lmbd;

public class MarkCommand extends Command {
    public MarkCommand() {
        super("mark", 1, "Marks the task associated with the number as done");
    }

    @Override
    void run(Lmbd lmbd, String[] args) {
        int id = Integer.valueOf(args[0]) - 1;
        if (id < 0 || id >= lmbd.tasks.getTaskSize()) {
            System.out.println("Invalid id");
            return;
        }
        boolean success = lmbd.tasks.mark(id, true);

        if (!success) {
            System.out
                .println(String.format("Task \"%s\" is already done, unable to mark", lmbd.tasks.getTaskTitle(id)));
            return;
        }

        System.out.println(String.format("The task \"%s\" has been marked as done.", lmbd.tasks.getTaskTitle(id)));
    }
}
