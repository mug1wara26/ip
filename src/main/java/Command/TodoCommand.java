package Command;

import Lmbd.Lmbd;
import Task.Todo;

public class TodoCommand extends Command {
  public TodoCommand() {
    super("todo", 1, "Creates a new TODO task");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    String name = String.join(" ", args);
    lmbd.add_task(new Todo(name));
    System.out.println(String.format("Added the TODO task %s, you now have %d tasks.", name, lmbd.task_size()));
  }
}
