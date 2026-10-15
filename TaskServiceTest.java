package taskservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService taskService;

    // Creates a fresh service before each test.
    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    // Checks that a task can be added.
    @Test
    public void testAddTask() {
        Task task = new Task("T001", "Homework", "Complete assignment");

        taskService.addTask(task);

        assertNotNull(taskService.getTask("T001"));
        assertEquals("Homework", taskService.getTask("T001").getName());
    }

    // Checks that duplicate task IDs are rejected.
    @Test
    public void testDuplicateTaskId() {
        Task firstTask = new Task("T001", "Homework", "Complete assignment");
        Task secondTask = new Task("T001", "Reading", "Read chapter one");

        taskService.addTask(firstTask);

        assertThrows(IllegalArgumentException.class, () ->
                taskService.addTask(secondTask));
    }

    // Checks that a null task cannot be added.
    @Test
    public void testAddNullTask() {
        assertThrows(IllegalArgumentException.class, () ->
                taskService.addTask(null));
    }

    // Checks that a task can be deleted.
    @Test
    public void testDeleteTask() {
        Task task = new Task("T001", "Homework", "Complete assignment");

        taskService.addTask(task);
        taskService.deleteTask("T001");

        assertNull(taskService.getTask("T001"));
    }

    // Checks that deleting a task that does not exist causes an error.
    @Test
    public void testDeleteMissingTask() {

        // Attempt to delete a task that was never added.
        assertThrows(IllegalArgumentException.class, () ->
                taskService.deleteTask("T999"));
    }
    // Checks that the name and description can be updated.
    @Test
    public void testUpdateTask() {
        Task task = new Task("T001", "Homework", "Complete assignment");

        taskService.addTask(task);
        taskService.updateTask("T001", "Reading", "Read chapter one");

        assertEquals("T001", taskService.getTask("T001").getTaskId());
        assertEquals("Reading", taskService.getTask("T001").getName());
        assertEquals("Read chapter one",
                taskService.getTask("T001").getDescription());
    }

    // Checks that an unknown task ID cannot be updated.
    @Test
    public void testUpdateMissingTask() {
        assertThrows(IllegalArgumentException.class, () ->
                taskService.updateTask("T999", "Reading", "Read chapter one"));
    }

    // Checks that an invalid update does not change the existing task.
    @Test
    public void testInvalidUpdate() {
        Task task = new Task("T001", "Homework", "Complete assignment");

        taskService.addTask(task);

        assertThrows(IllegalArgumentException.class, () ->
                taskService.updateTask("T001", null, "Read chapter one"));

        // The original values should remain unchanged.
        assertEquals("Homework", task.getName());
        assertEquals("Complete assignment", task.getDescription());
    }
}