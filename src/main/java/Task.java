public class Task {
  private String name;
  private boolean done;

  public Task(String name) {
    this.name = name;
    this.done = false;
  }

  public void mark(boolean done) {
    this.done = done;
  }

  public boolean isDone() {
    return done;
  }

  @Override
  public String toString() {
    return name;
  }
}
