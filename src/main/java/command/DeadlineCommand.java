package command;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import task.Deadline;
import task.Task;
import ui.Lmbd;

public class DeadlineCommand extends Command {
    public DeadlineCommand() {
        super("deadline", 1, "Creates a new DEADLINE task");
    }

    @Override
    void run(Lmbd lmbd, String[] args) {
        StringBuilder name = new StringBuilder();
        int curr = 0;
        while (curr < args.length && !args[curr].equals("/by")) {
            name.append(args[curr] + " ");
            curr += 1;
        }
        name.deleteCharAt(name.length() - 1);

        if (curr == args.length) {
            System.out.println("Expected /by, reached end of line instead");
            return;
        }

        curr += 1;
        StringBuilder by = new StringBuilder();
        while (curr < args.length) {
            by.append(args[curr] + " ");
            curr += 1;
        }
        by.deleteCharAt(by.length() - 1);

        LocalDate byDate;
        try {
            byDate = LocalDate.parse(by);
        } catch (DateTimeParseException e) {
            System.out.println("Expected a date in YYYY-MM-DD format");
            return;
        }

        Task t = new Deadline(name.toString(), byDate);
        lmbd.tasks.addTask(t);
        System.out.println(String.format("Added the DEADLINE task %s, you now have %d tasks.", t.taskTitle(),
            lmbd.tasks.getTaskSize()));
    }
}
