package task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDate from;
    private LocalDate to;

    public Event(String name, LocalDate from, LocalDate to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    @Override
    public String taskTitle() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
        return String.format("%s (from: %s, to: %s)", getName(), from.format(formatter), to.format(formatter));
    }

    @Override
    protected char typeChar() {
        return 'E';
    }
}
