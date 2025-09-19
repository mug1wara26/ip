package command;

import org.junit.jupiter.api.BeforeEach;

import task.Task;
import ui.Lmbd;

public class CommandTest { // Renamed from specific command names for clarity of purpose
    protected Lmbd lmbd;
    protected static final String SAVE_PATH = "data/test_tasks.txt";

    @BeforeEach
    void setUp() {
        // Initialize Lmbd with all commands for most tests
        lmbd = new Lmbd(SAVE_PATH, CommandRegistry.getCommands());
    }

    // Helper method to add tasks directly to Lmbd's task list for setup
    protected void addTaskDirectly(Task task) {
        lmbd.tasks.addTask(task);
    }
}
