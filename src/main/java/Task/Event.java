package Task;

public class Event extends Task {
  private String from;
  private String to;

  public Event(String name, String from, String to) {
    super(name);
    this.from = from;
    this.to = to;
  }

  @Override
  public String taskTitle() {
    return String.format("%s (from: %s, to: %s)", getName(), from, to);
  }

  @Override
  protected char typeChar() {
    return 'E';
  }
}
