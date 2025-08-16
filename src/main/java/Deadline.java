public class Deadline extends Task {
  private String by;

  public Deadline(String name, String by) {
    super(name);
    this.by = by;
  }

  @Override
  protected String taskTitle() {
    return String.format("%s (by: %s)", getName(), by);
  }

  @Override
  protected char typeChar() {
    return 'D';
  }
}
