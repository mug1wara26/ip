package task;

public class Todo extends Task {
    public Todo(String name) {
        super(name);
    }

    @Override
    public String taskTitle() {
        return getName();
    }

    @Override
    protected char typeChar() {
        return 'T';
    }
}
