import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lmbd {
  private static ArrayList<Task> tasks = new ArrayList<>();

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

  private static void print_horizontal_bar() {
    System.out.println("____________________________________________________________");
  }

  private static void greet() {
    System.out.println("Hello! I'm LMBD. What can I do for you?");
  }

  private static void exit() {
    System.out.println("Bye. Hope to see you again soon!");
    print_horizontal_bar();
    System.exit(0);
  }

  private static void display_list() {
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println(String.format("%d. [%s] %s", i + 1, tasks.get(i).isDone() ? "X" : " ", tasks.get(i)));
    }
  }

  private static void mark(int id) {
    tasks.get(id).mark(true);

    System.out.println(String.format("The task \"%s\" has been marked as done.", tasks.get(id)));
  }

  private static void unmark(int id) {
    tasks.get(id).mark(false);

    System.out.println(String.format("The task \"%s\" has been unmarked as done.", tasks.get(id)));
  }

  private static void listen() {
    Scanner sc = new Scanner(System.in);
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
      default:
        print_horizontal_bar();
        String name = cmd + " " + String.join(" ", args);
        System.out.println(String.format("added: %s", name));
        tasks.add(new Task(name));
        break;
    }
  }
}
