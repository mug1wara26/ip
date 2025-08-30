package ui;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import command.Command;
import task.TaskList;
import utils.Storage;

/** The main chatbot class, start the bot by calling the listen function */
public class Lmbd {
  /** A TaskList object associated with this class */
  public final TaskList TASKS;
  private Scanner sc = new Scanner(System.in);
  /**
   * A map between a String representing the command and the corresponding Command
   * object
   */
  private final Map<String, Command> commands = new HashMap<>();
  private boolean exit = false;

  public Lmbd(Command... cmds) {
    this("lmbd.save", cmds);
  }

  public Lmbd(String saveFile, Command... cmds) {
    TaskList temp;
    try {
      temp = Storage.load(saveFile);
    } catch (Exception e) {
      temp = new TaskList(saveFile);
    }

    TASKS = temp;

    for (Command command : cmds) {
      commands.put(command.getCmd(), command);
    }
  }

  public Collection<Command> getCommands() {
    return commands.values();
  }

  public Command getCommand(String cmdName) {
    return commands.get(cmdName);
  }

  public boolean isCommand(String cmdName) {
    return commands.containsKey(cmdName);
  }

  /** Prints a horizontal bar */
  public void printHorizontalBar() {
    System.out.println("____________________________________________________________");
  }

  /** Prints a greeting message */
  public void greet() {
    System.out.println("Hello! I'm LMBD. What can I do for you?");
  }

  /** Closes the chatbot */
  public void exit() {
    exit = true;
    sc.close();
  }

  /** Starts listening for commands from stdin */
  public void listen() {
    while (!exit) {
      printHorizontalBar();
      System.out.print("$ ");
      if (sc.hasNextLine()) {
        String[] in = sc.nextLine().split(" ");
        handleCommand(in[0], Arrays.copyOfRange(in, 1, in.length));
      } else {
        break;
      }
    }
  }

  private void handleCommand(String cmd_string, String[] args) {
    printHorizontalBar();
    Command command = commands.getOrDefault(cmd_string, null);
    if (command == null) {
      System.out.println(String.format("Unrecognised command: %s", cmd_string));
      return;
    }

    command.call(this, args);
  }
}
