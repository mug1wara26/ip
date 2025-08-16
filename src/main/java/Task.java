public abstract class Task {
  private String name;
  private boolean done;

  public Task(String name) {
    this.name = name;
    this.done = false;
  }

  public String getName() {
    return name;
  }

  public void mark(boolean done) {
    this.done = done;
  }

  public boolean isDone() {
    return done;
  }

  abstract protected String taskTitle();

  abstract protected char typeChar();

  @Override
  public String toString() {
    return String.format("[%s][%s] %s", typeChar(), done ? "X" : " ", taskTitle());
  }
}
