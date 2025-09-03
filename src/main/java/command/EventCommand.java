package command;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import task.Event;
import task.Task;
import ui.Lmbd;

public class EventCommand extends Command {
    public EventCommand() {
        super("event", 1, "Creates a new EVENT task");
    }

    @Override
    String run(Lmbd lmbd, String[] args) {
        StringBuilder name = new StringBuilder();
        int curr = 0;
        while (curr < args.length && !args[curr].equals("/from")) {
            name.append(args[curr] + " ");
            curr += 1;
        }
        name.deleteCharAt(name.length() - 1);

        if (curr == args.length) {
            return "Expected /from, reached end of line instead";
        }

        curr += 1;
        StringBuilder from = new StringBuilder();
        while (curr < args.length && !args[curr].equals("/to")) {
            from.append(args[curr] + " ");
            curr += 1;
        }
        from.deleteCharAt(from.length() - 1);

        if (curr == args.length) {
            return "Expected /to, reached end of line instead";
        }

        curr += 1;
        StringBuilder to = new StringBuilder();
        while (curr < args.length) {
            to.append(args[curr] + " ");
            curr += 1;
        }
        to.deleteCharAt(to.length() - 1);

        LocalDate fromDate;
        try {
            fromDate = LocalDate.parse(from);
        } catch (DateTimeParseException e) {
            return "Expected \"from\" to be in YYYY-MM-DD format";
        }
        LocalDate toDate;
        try {
            toDate = LocalDate.parse(to);
        } catch (DateTimeParseException e) {
            return "Expected \"to\" to be in YYYY-MM-DD format";
        }

        Task t = new Event(name.toString(), fromDate, toDate);
        lmbd.tasks.addTask(t);
        return String.format("Added the EVENT task %s, you now have %d tasks.", t.taskTitle(),
            lmbd.tasks.getTaskSize());
    }
}
