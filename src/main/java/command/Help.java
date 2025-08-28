package command;

import ui.Lmbd;

public class Help extends Command {
  public Help() {
    super("help", 0, "Gives a helpful description of a command");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    if (args.length == 0) {
      System.out.println("Here are a list of commands:");
      for (Command cmd : lmbd.commands.values()) {
        System.out.println(String.format("%s - %s", cmd.getCmd(), cmd.getHelpText()));
      }
    } else if (lmbd.commands.containsKey(args[0])) {
      System.out.println(lmbd.commands.get(args[0]).getHelpText());
    } else {
      System.out.println(String.format("Command %s not found", args[0]));
    }
  }
}
