package command;

import ui.Lmbd;

public class Mark extends Command {
  public Mark() {
    super("mark", 1, "Marks the task associated with the number as done");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    int id = Integer.valueOf(args[0]) - 1;
    if (id < 0 || id >= lmbd.TASKS.getTaskSize()) {
      System.out.println("Invalid id");
      return;
    }
    boolean success = lmbd.TASKS.mark(id, true);

    if (!success) {
      System.out.println(String.format("Task \"%s\" is already done, unable to mark", lmbd.TASKS.getTaskTitle(id)));
      return;
    }

    System.out.println(String.format("The task \"%s\" has been marked as done.", lmbd.TASKS.getTaskTitle(id)));

  }
}
