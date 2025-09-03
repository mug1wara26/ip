package command;

import ui.Lmbd;

public class ByeCommand extends Command {
    public ByeCommand() {
        super("bye", 0, "Exits the program");
    }

    @Override
    String run(Lmbd lmbd, String[] args) {
        lmbd.exit();
        return "Bye. Hope to see you again soon!";
    }
}
