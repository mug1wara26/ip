import java.util.Arrays;
import java.util.Scanner;

public class Lmbd {
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
    print_horizontal_bar();
    System.out.println("Hello! I'm LMBD. What can I do for you?");
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
    switch (cmd) {
      case "bye":
        exit();
      default:
        print_horizontal_bar();
        System.out.println(cmd + " " + String.join(" ", args));
    }
  }

  private static void exit() {
    print_horizontal_bar();
    System.out.println("Bye. Hope to see you again soon!");
    print_horizontal_bar();
    System.exit(0);
  }
}
