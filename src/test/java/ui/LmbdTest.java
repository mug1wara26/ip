package ui;

import org.junit.jupiter.api.Test;

import command.ByeCommand;

public class LmbdTest {

    @Test
    public void listen_startUpAndExit_noErrors() {
        Lmbd lmbd = new Lmbd(new ByeCommand());
        lmbd.getResponse("bye");
    }
}
