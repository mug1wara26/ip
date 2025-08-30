package command;

import task.Todo;
import ui.Lmbd;

public class TodoCommand extends Command {
  public TodoCommand() {
    super("todo", 1, "Creates a new TODO task");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    String name = String.join(" ", args);
    lmbd.TASKS.addTask(new Todo(name));
    System.out.println(String.format("Added the TODO task %s, you now have %d tasks.", name, lmbd.TASKS.getTaskSize()));
  }
}
