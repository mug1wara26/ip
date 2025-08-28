package ui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import command.*;
import task.TaskList;

public class Lmbd {
  public final TaskList TASKS;
  private Scanner sc = new Scanner(System.in);
  public final Map<String, Command> commands = new HashMap<>();

  public Lmbd() {
    TaskList temp;
    try {
      temp = TaskList.load();
    } catch (Exception e) {
      temp = new TaskList();
    }

    TASKS = temp;
  }

  public void close_sc() {
    sc.close();
  }

  public void print_horizontal_bar() {
    System.out.println("____________________________________________________________");
  }

  public void greet() {
    System.out.println("Hello! I'm LMBD. What can I do for you?");
  }

  public void listen() {
    while (true) {
      print_horizontal_bar();
      System.out.print("$ ");
      String[] in = sc.nextLine().split(" ");
      handle_command(in[0], Arrays.copyOfRange(in, 1, in.length));
    }
  }

  private void handle_command(String cmd_string, String[] args) {
    print_horizontal_bar();
    Command command = commands.getOrDefault(cmd_string, null);
    if (command == null) {
      System.out.println(String.format("Unrecognised command: %s", cmd_string));
      return;
    }

    command.call(this, args);
  }
}
