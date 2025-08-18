package Command;

import Lmbd.Lmbd;

public class DisplayList extends Command {
  public DisplayList() {
    super("list", 0, "Displays the list of tasks");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    System.out.println(String.format("You have %d tasks:", lmbd.task_size()));
    for (int i = 0; i < lmbd.task_size(); i++) {
      System.out.println(String.format("%d. %s", i + 1, lmbd.get_task(i)));
    }
  }
}
