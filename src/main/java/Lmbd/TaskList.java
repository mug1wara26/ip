package Lmbd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Task.*;

public class TaskList implements Serializable {
  private ArrayList<Task> tasks;
  private static final String SAVE_PATH = "lmbd.save";

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
    t.associateList(this);
    tasks.add(t);
    try {
      save();
    } catch (IOException e) {
      System.out.println("Unable to backup task list, your data might be lost.");
    }
  }

  public Task remove_task(int id) {
    return tasks.remove(id);
  }

  public void save() throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(SAVE_PATH);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(this);
    objectOutputStream.flush();
    objectOutputStream.close();
  }

  public static TaskList load() throws IOException, ClassNotFoundException {
    FileInputStream fileInputStream = new FileInputStream(SAVE_PATH);
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    TaskList ret = (TaskList) objectInputStream.readObject();
    objectInputStream.close();

    return ret;
  }
}
