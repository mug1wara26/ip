package command;

import ui.Lmbd;

public class ByeCommand extends Command {
  public ByeCommand() {
    super("bye", 0, "Exits the program");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    System.out.println("Bye. Hope to see you again soon!");
    lmbd.printHorizontalBar();
    lmbd.exit();
  }
}
