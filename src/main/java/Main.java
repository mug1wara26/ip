import command.ByeCommand;
import command.Command;
import command.DeadlineCommand;
import command.EventCommand;
import command.FindCommand;
import command.HelpCommand;
import command.ListCommand;
import command.MarkCommand;
import command.RemoveCommand;
import command.TodoCommand;
import command.UnmarkCommand;
import ui.Lmbd;

public class Main {
    public static void main(String[] args) {
        String logo = "██╗     ███╗   ███╗██████╗ ██████╗ \n" + "██║     ████╗ ████║██╔══██╗██╔══██╗\n"
            + "██║     ██╔████╔██║██████╔╝██║  ██║\n" + "██║     ██║╚██╔╝██║██╔══██╗██║  ██║\n"
            + "███████╗██║ ╚═╝ ██║██████╔╝██████╔╝\n" + "╚══════╝╚═╝     ╚═╝╚═════╝ ╚═════╝ \n";
        System.out.println(logo);

        Command[] cmds = new Command[]{new HelpCommand(), new ByeCommand(), new ListCommand(), new MarkCommand(),
            new UnmarkCommand(), new TodoCommand(), new EventCommand(), new DeadlineCommand(), new RemoveCommand(),
            new FindCommand()};
        Lmbd lmbd = new Lmbd(cmds);

        lmbd.greet();
        lmbd.listen();
    }
}
