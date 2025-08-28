package command;

import task.Task;
import ui.Lmbd;

public class Mark extends Command {
  public Mark() {
    super("mark", 1, "Marks the task associated with the number as done");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    int id = Integer.valueOf(args[0]) - 1;
    if (id < 0 || id >= lmbd.TASKS.task_size()) {
      System.out.println("Invalid id");
      return;
    }
    Task t = lmbd.TASKS.get_task(id);
    if (t.isDone()) {
      System.out.println(String.format("Task \"%s\" is already done, unable to mark", t.taskTitle()));
      return;
    }
    t.mark(true);

    System.out.println(String.format("The task \"%s\" has been marked as done.", t.taskTitle()));

  }
}
