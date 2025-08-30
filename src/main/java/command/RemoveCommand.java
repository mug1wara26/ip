package command;

import task.Task;
import ui.Lmbd;

public class RemoveCommand extends Command {
  public RemoveCommand() {
    super("remove", 1, "Removes the task from the list with the associated number");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    int id = Integer.valueOf(args[0]);
    if (id < 0 || id >= lmbd.TASKS.getTaskSize()) {
      System.out.println("Invalid id");
      return;
    }
    Task t = lmbd.TASKS.removeTask(id);

    System.out.println(String.format("The task \"%s\" has been removed.", t.taskTitle()));

  }
}
