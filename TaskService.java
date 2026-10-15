package taskservice;

import java.util.ArrayList;

public class TaskService {

    // Keeps the tasks in memory while the program is running.
    private final ArrayList<Task> taskList = new ArrayList<>();

    // Searches the list and returns the task with the matching ID.
    private Task findTask(String taskId) {

        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                return task;
            }
        }

        // Return null when the ID is not found.
        return null;
    }

    // Adds a task as long as its ID is not already in use.
    public void addTask(Task task) {

        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }

        if (findTask(task.getTaskId()) != null) {
            throw new IllegalArgumentException("Task ID already exists.");
        }

        taskList.add(task);
    }

    // Removes a task when its ID is found.
    public void deleteTask(String taskId) {

        // Search for the task using the supplied ID.
        Task task = findTask(taskId);

        // Stop and report an error if the task does not exist.
        if (task == null) {
            throw new IllegalArgumentException("Task was not found.");
        }

        // Remove the task from the in-memory list.
        taskList.remove(task);
    }
    
    // Updates the two fields allowed by the requirements.
    public void updateTask(String taskId, String name, String description) {

        Task task = findTask(taskId);

        if (task == null) {
            throw new IllegalArgumentException("Task was not found.");
        }

        // Check both values before changing the task.
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid task name.");
        }

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid task description.");
        }

        task.setName(name);
        task.setDescription(description);
    }

    // Allows the tests to check what is currently stored.
    public Task getTask(String taskId) {
        return findTask(taskId);
    }
}
