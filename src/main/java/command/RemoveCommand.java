package command;

import task.Task;
import ui.Lmbd;

public class RemoveCommand extends Command {
    public RemoveCommand() {
        super("remove", 1, "Removes the task from the list with the associated number");
    }

    @Override
    void run(Lmbd lmbd, String[] args) {
        int id = Integer.valueOf(args[0]);
        if (id < 0 || id >= lmbd.tasks.getTaskSize()) {
            System.out.println("Invalid id");
            return;
        }
        Task t = lmbd.tasks.removeTask(id);

        System.out.println(String.format("The task \"%s\" has been removed.", t.taskTitle()));
    }
}
