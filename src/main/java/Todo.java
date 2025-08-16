public class Todo extends Task {
  public Todo(String name) {
    super(name);
  }

  @Override
  protected String taskTitle() {
    return getName();
  }

  @Override
  protected char typeChar() {
    return 'T';
  }
}
