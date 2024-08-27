import java.time.LocalDateTime;

public class EventCommand implements Command {

    private final String taskDescription;

    private final LocalDateTime startTime;

    private final LocalDateTime endTime;

    public EventCommand(String taskDescription, LocalDateTime startTime, LocalDateTime endTime) {
        this.taskDescription = taskDescription;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public void execute(Storage storage, TaskList tasks, Ui ui) throws DownyException {
        Event e = tasks.addEvent(this.taskDescription, this.startTime, this.endTime);
        storage.writeEventToFile(e);
        ui.displayTaskAdded(e, tasks.getSize());
    }
    public boolean isExit() {
        return false;
    }

}
