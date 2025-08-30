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

    Command[] cmds = new Command[] {
        new HelpCommand(),
        new ByeCommand(),
        new ListCommand(),
        new MarkCommand(),
        new UnmarkCommand(),
        new TodoCommand(),
        new EventCommand(),
        new DeadlineCommand(),
        new RemoveCommand(),
        new FindCommand()
    };
    Lmbd lmbd = new Lmbd(cmds);

    lmbd.greet();
    lmbd.listen();
  }
}
