package duke.task;

/**
 * Represents a generic task.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a Task object with the specified description.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the status icon of the task.
     *
     * @return The status icon, "X" if the task is done, " " otherwise.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Returns a string representation of the task.
     *
     * @return The description of the task.
     */
    public String toString() {
        return description;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Returns a string representation of the task for file writing.
     * The implementation for this method is dependent on the type of task,
     * and is hence overridden in the subclasses of Task.
     *
     * @return A string representation of the task for file writing.
     */
    public String toFileString() {
        return ""; // Override in subclasses
    }
}
