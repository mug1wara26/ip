package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import task.TaskList;

public class Storage {
  private static final String SAVE_PATH = "lmbd.save";

  /** Serialises and writes to a save file named lmbd.save */
  public static void save(TaskList taskList) throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(SAVE_PATH);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(taskList);
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
}
