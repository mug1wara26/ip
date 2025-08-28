package task;

import java.io.IOException;
import java.io.Serializable;

/**
 * The Task class represents tasks that have a name and whether it is marked as
 * done or not. Task objects must call the associateList function after
 * instantiation
 */
public abstract class Task implements Serializable {
  private String name;
  private boolean done;
  private TaskList tl;

  public Task(String name) {
    this.name = name;
    this.done = false;
  }

  /** Returns the name of this class */
  public String getName() {
    return name;
  }

  /**
   * Marks this task as done or not, associateList must be called before this
   * function is called
   */
  public void mark(boolean done) {
    this.done = done;
    try {
      tl.save();
    } catch (IOException e) {
      System.out.println("Unable to backup task list, your data might be lost.");
    }
  }

  /**
   * Associates the given TaskList to this class so that TaskList.save can be
   * called
   */
  public void associateList(TaskList tl) {
    this.tl = tl;
  }

  /** Whether this task is marked as done or not */
  public boolean isDone() {
    return done;
  }

  /** The title of this task */
  abstract public String taskTitle();

  abstract protected char typeChar();

  @Override
  public String toString() {
    return String.format("[%s][%s] %s", typeChar(), done ? "X" : " ", taskTitle());
  }
}
