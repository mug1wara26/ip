package command;

import ui.Lmbd;

public abstract class Command {
  private String cmd;
  private String help_text;
  private int num_required_args;

  public Command(String cmd, int num_required_args, String help_text) {
    this.cmd = cmd;
    this.num_required_args = num_required_args;
    this.help_text = help_text;
  }

  /**
   * Runs this command using the arguments
   * 
   * @param lmbd The Lmbd object that received this command
   * @param args An array of arguments following the command, separated by spaces
   */
  public void call(Lmbd lmbd, String[] args) {
    if (args.length < num_required_args)
      System.out.println(String.format("%s command requires at least %d args", cmd, num_required_args));
    else
      call_(lmbd, args);
  }

  abstract void call_(Lmbd lmbd, String[] args);

  /** Returns the help text for this command */
  public String get_help_text() {
    return help_text;
  }

  /** Returns the string that calls this command */
  public String get_cmd() {
    return cmd;
  }
}
