package task;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utils.Storage;

/**
 * A class storing a list of Tasks, is serializable and handles saving and
 * loading
 */
public class TaskList implements Serializable {
  private ArrayList<Task> tasks;

  public TaskList() {
    tasks = new ArrayList<>();
  }

  /** Get number of tasks in the list */
  public int getTaskSize() {
    return tasks.size();
  }

  /** Adds the given Task object to the list */
  public void addTask(Task t) {
    t.associateList(this);
    tasks.add(t);
    try {
      Storage.save(this);
    } catch (IOException e) {
      System.out.println("Unable to backup task list, your data might be lost.");
    }
  }

  public boolean mark(int index, boolean isMarked) {
    boolean m = tasks.get(index).isDone();
    tasks.get(index).mark(isMarked);

    return m != isMarked;
  }

  public boolean isMarked(int index) {
    return tasks.get(index).isDone();
  }

  public String getTaskTitle(int index) {
    return tasks.get(index).taskTitle();
  }

  public String getTaskToString(int index) {
    return tasks.get(index).toString();
  }

  /** Removes the task from the list at the given index */
  public Task removeTask(int index) {
    return tasks.remove(index);
  }

  public List<Task> find(String pattern) {
    return tasks.stream().filter(x -> x.match(pattern)).collect(Collectors.toList());
  }
}
