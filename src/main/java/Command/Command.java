package Command;

import Lmbd.Lmbd;

public abstract class Command {
  private String cmd;
  private String help_text;
  private int num_required_args;

  public Command(String cmd, int num_required_args, String help_text) {
    this.cmd = cmd;
    this.num_required_args = num_required_args;
    this.help_text = help_text;
  }

  public void call(Lmbd lmbd, String[] args) {
    if (args.length < num_required_args)
      System.out.println(String.format("%s command requires at least %d args", cmd, num_required_args));
    else
      call_(lmbd, args);
  }

  abstract void call_(Lmbd lmbd, String[] args);

  public String get_help_text() {
    return help_text;
  }

  public String get_cmd() {
    return cmd;
  }
}
