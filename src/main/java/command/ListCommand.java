package command;

import ui.Lmbd;

public class ListCommand extends Command {
  public ListCommand() {
    super("list", 0, "Displays the list of tasks");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    System.out.println(String.format("You have %d tasks:", lmbd.TASKS.getTaskSize()));
    for (int i = 0; i < lmbd.TASKS.getTaskSize(); i++) {
      System.out.println(String.format("%d. %s", i + 1, lmbd.TASKS.getTaskToString(i)));
    }
  }
}
