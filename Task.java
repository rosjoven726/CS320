package taskservice;

public class Task {

    // Every task needs its own ID.
    // final prevents the ID from being changed later.
    private final String taskId;

    // These two fields can be updated.
    private String name;
    private String description;

    // Set up a new task with its ID, name, and description.
    public Task(String taskId, String name, String description) {

        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID.");
        }

        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid task name.");
        }

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid task description.");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // The ID is read-only.
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    // Change the name only when the new value is valid.
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid task name.");
        }

        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    // Change the description only when the new value is valid.
    public void setDescription(String description) {
    	if (description == null || description.length() > 50) {
            throw new IllegalArgumentException(
                    "Task description cannot be null or longer than 50 characters.");
        }

        this.description = description;
    }
}