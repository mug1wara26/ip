package Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
  private LocalDate by;

  public Deadline(String name, LocalDate by) {
    super(name);
    this.by = by;
  }

  @Override
  public String taskTitle() {
    return String.format("%s (by: %s)", getName(), by.format(DateTimeFormatter.ofPattern("MMM d yyyy")));
  }

  @Override
  protected char typeChar() {
    return 'D';
  }
}
