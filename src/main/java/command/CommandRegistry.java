package command;

// This solution was suggested by ChatGPT
public class CommandRegistry {
    public static Command[] getCommands() {
        return new Command[]{new ByeCommand(), new DeadlineCommand(), new EventCommand(), new FindCommand(),
            new HelpCommand(), new ListCommand(), new MarkCommand(), new RemoveCommand(), new TodoCommand(),
            new UnmarkCommand()};
    }
}
