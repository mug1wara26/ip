package command;

import task.Todo;
import ui.Lmbd;

public class TodoCommand extends Command {
    public TodoCommand() {
        super("todo", 1, "Creates a new TODO task");
    }

    @Override
    String run(Lmbd lmbd, String[] args) {
        String name = String.join(" ", args);
        lmbd.tasks.addTask(new Todo(name));
        return String.format("Added the TODO task %s, you now have %d tasks.", name, lmbd.tasks.getTaskSize());
    }
}
