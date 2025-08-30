package command;

import ui.Lmbd;

public class UnmarkCommand extends Command {
  public UnmarkCommand() {
    super("unmark", 1, "Unmarks the task associated with the number as done");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    int id = Integer.valueOf(args[0]) - 1;
    if (id < 0 || id >= lmbd.TASKS.getTaskSize()) {
      System.out.println("Invalid id");
      return;
    }

    boolean success = lmbd.TASKS.mark(id, false);

    if (!success) {
      System.out.println(String.format("Task \"%s\" is not done, unable to unmark", lmbd.TASKS.getTaskTitle(id)));
      return;
    }

    System.out.println(String.format("The task \"%s\" has been unmarked.", lmbd.TASKS.getTaskTitle(id)));
  }
}
