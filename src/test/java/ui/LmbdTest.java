package ui;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

import command.ByeCommand;

public class LmbdTest {

    @Test
    public void listen_startUpAndExit_noErrors() {
        System.setIn(new ByteArrayInputStream("bye\n".getBytes()));
        Lmbd lmbd = new Lmbd(new ByeCommand());
        lmbd.listen();
    }
}
