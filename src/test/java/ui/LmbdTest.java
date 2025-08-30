package ui;

import org.junit.jupiter.api.Test;

import command.ByeCommand;

import java.io.ByteArrayInputStream;

public class LmbdTest {

  @Test
  public void listen_startUpAndExit_noErrors() {
    System.setIn(new ByteArrayInputStream("bye\n".getBytes()));
    Lmbd lmbd = new Lmbd(new ByeCommand());
    lmbd.listen();
  }
}
