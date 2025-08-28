package command;

import java.util.List;

import task.Task;
import ui.Lmbd;

public class FindCommand extends Command {
  public FindCommand() {
    super("find", 1, "Finds all tasks with a name matching the regex pattern");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    List<Task> tasks = lmbd.TASKS.find(String.join(" ", args));
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println(String.format("%d. %s", i + 1, tasks.get(i)));
    }
  }
}
