package Task;

import java.io.IOException;
import java.io.Serializable;

import Lmbd.TaskList;

public abstract class Task implements Serializable {
  private String name;
  private boolean done;
  private TaskList tl;

  public Task(String name) {
    this.name = name;
    this.done = false;
  }

  public String getName() {
    return name;
  }

  public void mark(boolean done) {
    this.done = done;
    try {
      tl.save();
    } catch (IOException e) {
      System.out.println("Unable to backup task list, your data might be lost.");
    }
  }

  public void associateList(TaskList tl) {
    this.tl = tl;
  }

  public boolean isDone() {
    return done;
  }

  abstract public String taskTitle();

  abstract protected char typeChar();

  @Override
  public String toString() {
    return String.format("[%s][%s] %s", typeChar(), done ? "X" : " ", taskTitle());
  }
}
