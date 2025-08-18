package Command;

import Lmbd.Lmbd;

public class Help extends Command {
  public Help() {
    super("help", 0, "Gives a helpful description of a command");
  }

  @Override
  void call_(Lmbd lmbd, String[] args) {
    if (args.length == 0) {
      System.out.println("Here are a list of commands:");
      for (Command cmd : lmbd.commands.values()) {
        System.out.println(String.format("%s - %s", cmd.get_cmd(), cmd.get_help_text()));
      }
    } else if (lmbd.commands.containsKey(args[0])) {
      System.out.println(lmbd.commands.get(args[0]).get_help_text());
    } else {
      System.out.println(String.format("Command %s not found", args[0]));
    }
  }
}
