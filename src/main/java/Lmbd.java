import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lmbd {
  private static ArrayList<Task> tasks = new ArrayList<>();
  private static Scanner sc = new Scanner(System.in);

  private static void print_horizontal_bar() {
    System.out.println("____________________________________________________________");
  }

  private static void greet() {
    System.out.println("Hello! I'm LMBD. What can I do for you?");
  }

  private static void exit() {
    System.out.println("Bye. Hope to see you again soon!");
    print_horizontal_bar();
    sc.close();
    System.exit(0);
  }

  private static void display_list() {
    System.out.println(String.format("You have %d tasks:", tasks.size()));
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println(String.format("%d. %s", i + 1, tasks.get(i)));
    }
  }

  private static void mark(int id) {
    if (id < 0 || id >= tasks.size()) {
      System.out.println("Invalid id");
      return;
    }
    tasks.get(id).mark(true);

    System.out.println(String.format("The task \"%s\" has been marked as done.", tasks.get(id).taskTitle()));
  }

  private static void unmark(int id) {
    if (id < 0 || id >= tasks.size()) {
      System.out.println("Invalid id");
      return;
    }
    Task t = tasks.get(id);

    if (!t.isDone()) {
      System.out.println(String.format("Task \"%s\" is not done, unable to unmark", t.taskTitle()));
      return;
    }

    t.mark(false);
    System.out.println(String.format("The task \"%s\" has been unmarked as done.", tasks.get(id).taskTitle()));
  }

  private static void new_todo(String[] args) {
    String name = String.join(" ", args);
    tasks.add(new Todo(name));
    System.out.println(String.format("Added the TODO task %s, you now have %d tasks.", name, tasks.size()));
  }

  private static void new_event(String[] args) {
    StringBuilder name = new StringBuilder();
    int curr = 0;
    while (curr < args.length && !args[curr].equals("/from")) {
      name.append(args[curr] + " ");
      curr += 1;
    }
    name.deleteCharAt(name.length() - 1);

    if (curr == args.length) {
      System.out.println("Expected /from, reached end of line instead");
      return;
    }

    curr += 1;
    StringBuilder from = new StringBuilder();
    while (curr < args.length && !args[curr].equals("/to")) {
      from.append(args[curr] + " ");
      curr += 1;
    }
    from.deleteCharAt(from.length() - 1);

    if (curr == args.length) {
      System.out.println("Expected /to, reached end of line instead");
      return;
    }

    curr += 1;
    StringBuilder to = new StringBuilder();
    while (curr < args.length) {
      to.append(args[curr] + " ");
      curr += 1;
    }
    to.deleteCharAt(to.length() - 1);

    Task t = new Event(name.toString(), from.toString(), to.toString());
    tasks.add(t);
    System.out.println(String.format("Added the EVENT task %s, you now have %d tasks.", t.taskTitle(), tasks.size()));
  }

  private static void new_deadline(String[] args) {
    StringBuilder name = new StringBuilder();
    int curr = 0;
    while (curr < args.length && !args[curr].equals("/by")) {
      name.append(args[curr] + " ");
      curr += 1;
    }
    name.deleteCharAt(name.length() - 1);

    if (curr == args.length) {
      System.out.println("Expected /by, reached end of line instead");
      return;
    }

    curr += 1;
    StringBuilder by = new StringBuilder();
    while (curr < args.length) {
      by.append(args[curr] + " ");
      curr += 1;
    }
    by.deleteCharAt(by.length() - 1);

    Task t = new Deadline(name.toString(), by.toString());
    tasks.add(t);
    System.out
        .println(String.format("Added the DEADLINE task %s, you now have %d tasks.", t.taskTitle(), tasks.size()));
  }

  private static void listen() {
    while (true) {
      print_horizontal_bar();
      System.out.print("$ ");
      String[] in = sc.nextLine().split(" ");
      handle_command(in[0], Arrays.copyOfRange(in, 1, in.length));
    }
  }

  private static void handle_command(String cmd, String[] args) {
    print_horizontal_bar();
    switch (cmd) {
      case "bye":
        exit();
        break;
      case "list":
        display_list();
        break;
      case "mark":
        mark(Integer.valueOf(args[0]) - 1);
        break;
      case "unmark":
        unmark(Integer.valueOf(args[0]) - 1);
        break;
      case "todo":
        new_todo(args);
        break;
      case "event":
        new_event(args);
        break;
      case "deadline":
        new_deadline(args);
        break;
    }
  }

  public static void main(String[] args) {
    String logo = "██╗     ███╗   ███╗██████╗ ██████╗ \n"
        + "██║     ████╗ ████║██╔══██╗██╔══██╗\n"
        + "██║     ██╔████╔██║██████╔╝██║  ██║\n"
        + "██║     ██║╚██╔╝██║██╔══██╗██║  ██║\n"
        + "███████╗██║ ╚═╝ ██║██████╔╝██████╔╝\n"
        + "╚══════╝╚═╝     ╚═╝╚═════╝ ╚═════╝ \n";
    System.out.println(logo);

    greet();
    listen();
  }
}
