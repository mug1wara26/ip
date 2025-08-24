package Lmbd;

import java.util.ArrayList;

import Task.*;

public class TaskList {
  private ArrayList<Task> tasks;

  public TaskList() {
    tasks = new ArrayList<>();
  }

  public int task_size() {
    return tasks.size();
  }

  public Task get_task(int id) {
    return tasks.get(id);
  }

  public void add_task(Task t) {
    tasks.add(t);
  }

  public Task remove_task(int id) {
    return tasks.remove(id);
  }
}
