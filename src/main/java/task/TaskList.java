package task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class storing a list of Tasks, is serializable and handles saving and
 * loading
 */
public class TaskList implements Serializable {
  private ArrayList<Task> tasks;
  private static final String SAVE_PATH = "lmbd.save";

  public TaskList() {
    tasks = new ArrayList<>();
  }

  /** Get number of tasks in the list */
  public int task_size() {
    return tasks.size();
  }

  /** Get a task from the given index in the list */
  public Task get_task(int index) {
    return tasks.get(index);
  }

  /** Adds the given Task object to the list */
  public void add_task(Task t) {
    t.associateList(this);
    tasks.add(t);
    try {
      save();
    } catch (IOException e) {
      System.out.println("Unable to backup task list, your data might be lost.");
    }
  }

  /** Removes the task from the list at the given index */
  public Task remove_task(int index) {
    return tasks.remove(index);
  }

  /** Serialises and writes to a save file named lmbd.save */
  public void save() throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(SAVE_PATH);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(this);
    objectOutputStream.flush();
    objectOutputStream.close();
  }

  /**
   * Deserialises the TaskList from the lmbd.save file
   *
   * @return Deserialised TaskList
   */
  public static TaskList load() throws IOException, ClassNotFoundException {
    FileInputStream fileInputStream = new FileInputStream(SAVE_PATH);
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    TaskList ret = (TaskList) objectInputStream.readObject();
    objectInputStream.close();

    return ret;
  }

  public List<Task> find(String pattern) {
    return tasks.stream().filter(x -> x.match(pattern)).collect(Collectors.toList());
  }
}
