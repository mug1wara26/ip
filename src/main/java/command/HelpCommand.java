package command;

import ui.Lmbd;

public class HelpCommand extends Command {
  public HelpCommand() {
    super("help", 0, "Gives a helpful description of a command");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    if (args.length == 0) {
      System.out.println("Here are a list of commands:");
      for (Command cmd : lmbd.getCommands()) {
        System.out.println(String.format("%s - %s", cmd.getCmd(), cmd.getHelpText()));
      }
    } else if (lmbd.isCommand(args[0])) {
      System.out.println(lmbd.getCommand(args[0]).getHelpText());
    } else {
      System.out.println(String.format("Command %s not found", args[0]));
    }
  }
}
