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
    exit();
  }

  private static void print_horizontal_bar() {
    System.out.println("____________________________________________________________");
  }

  private static void greet() {
    print_horizontal_bar();
    System.out.println("Hello! I'm LMBD. What can I do for you?");
  }

  private static void exit() {
    print_horizontal_bar();
    System.out.println("Bye. Hope to see you again soon!");
    print_horizontal_bar();
  }
}
