package command;

import ui.Lmbd;

public abstract class Command {
    private String cmd;
    private String helpText;
    private int numRequiredArgs;

    public Command(String cmd, int numRequiredArgs, String helpText) {
        this.cmd = cmd;
        this.numRequiredArgs = numRequiredArgs;
        this.helpText = helpText;
    }

    /**
     * Runs this command using the arguments
     *
     * @param lmbd
     *            The Lmbd object that received this command
     * @param args
     *            An array of arguments following the command, separated by spaces
     */
    public String call(Lmbd lmbd, String[] args) {
        if (args.length < numRequiredArgs) {

            return String.format("%s command requires at least %d args", cmd, numRequiredArgs);
        } else {
            return run(lmbd, args);
        }
    }

    abstract String run(Lmbd lmbd, String[] args);

    /** Returns the help text for this command */
    public String getHelpText() {
        return helpText;
    }

    /** Returns the string that calls this command */
    public String getCmd() {
        return cmd;
    }
}
