package utils;

import org.junit.jupiter.api.Test;

import command.ByeCommand;
import command.MarkCommand;
import command.TodoCommand;
import task.TaskList;
import ui.Lmbd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class StorageTest {
  private Lmbd lmbd;

  public StorageTest() {
    System.setIn(new ByteArrayInputStream("todo test\n".getBytes()));
    System.setIn(new ByteArrayInputStream("todo test2\n".getBytes()));
    System.setIn(new ByteArrayInputStream("mark 2\n".getBytes()));
    System.setIn(new ByteArrayInputStream("bye\n".getBytes()));
    lmbd = new Lmbd(new TodoCommand(), new MarkCommand(), new ByeCommand());
    lmbd.listen();
  }

  @Test
  public void saveAndLoad_todoEvents_loadTodoEvents() {
    try {
      TaskList tl = Storage.load();
      assertEquals(2, tl.getTaskSize(), "Expected task size to be 2");
      assertEquals("test", tl.getTaskToString(1), "Expected name of first task to be \"test\"");
      assertEquals("test2", tl.getTaskToString(2), "Expected name of first task to be \"test2\"");
      assertEquals(false, tl.isMarked(1), "Expected first task to not be marked as done");
      assertEquals(true, tl.isMarked(2), "Expected second task to be marked as done");
    } catch (ClassNotFoundException e) {
      assertEquals(false, true, e.getMessage());
    } catch (IOException e) {
      assertEquals(false, true, e.getMessage());
    }
  }
}
