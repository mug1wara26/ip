package Command;

import Lmbd.Lmbd;
import Task.Task;

public class UnmarkCommand extends Command {
  public UnmarkCommand() {
    super("unmark", 1, "Unmarks the task associated with the number as done");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    int id = Integer.valueOf(args[0]) - 1;
    if (id < 0 || id >= lmbd.task_size()) {
      System.out.println("Invalid id");
      return;
    }
    Task t = lmbd.get_task(id);

    if (!t.isDone()) {
      System.out.println(String.format("Task \"%s\" is not done, unable to unmark", t.taskTitle()));
      return;
    }

    t.mark(false);
    System.out.println(String.format("The task \"%s\" has been unmarked as done.", t.taskTitle()));
  }
}
