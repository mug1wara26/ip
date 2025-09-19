package command;

import task.Task;
import ui.Lmbd;

public class RemoveCommand extends Command {
    public RemoveCommand() {
        super("remove", 1, "Removes the task from the list with the associated number");
    }

    @Override
    String run(Lmbd lmbd, String[] args) {
        try {
            int id = Integer.valueOf(args[0]) - 1;
            if (id < 0 || id >= lmbd.tasks.getTaskSize()) {
                return "Invalid id";
            }
            Task t = lmbd.tasks.removeTask(id);

            return String.format("The task \"%s\" has been removed.", t.taskTitle());
        } catch (NumberFormatException e) {
            return "Expected a number";
        }

    }
}
