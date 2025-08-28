import command.*;
import ui.Lmbd;

public class Main {
  public static void main(String[] args) {
    String logo = "██╗     ███╗   ███╗██████╗ ██████╗ \n"
        + "██║     ████╗ ████║██╔══██╗██╔══██╗\n"
        + "██║     ██╔████╔██║██████╔╝██║  ██║\n"
        + "██║     ██║╚██╔╝██║██╔══██╗██║  ██║\n"
        + "███████╗██║ ╚═╝ ██║██████╔╝██████╔╝\n"
        + "╚══════╝╚═╝     ╚═╝╚═════╝ ╚═════╝ \n";
    System.out.println(logo);

    Lmbd lmbd = new Lmbd();
    Command[] cmds = new Command[] {
        new Help(),
        new Bye(),
        new DisplayList(),
        new Mark(),
        new UnmarkCommand(),
        new TodoCommand(),
        new EventCommand(),
        new DeadlineCommand(),
        new RemoveCommand(),
        new FindCommand()
    };

    for (Command command : cmds) {
      lmbd.commands.put(command.getCmd(), command);
    }

    lmbd.greet();
    lmbd.listen();
  }
}
