package taskservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    // A camping task should accept valid information.
    @Test
    public void testCreateCampingTask() {
        Task task = new Task(
                "CAMP01",
                "Pack tent",
                "Check tent and poles"
        );

        assertEquals("CAMP01", task.getTaskId());
        assertEquals("Pack tent", task.getName());
        assertEquals("Check tent and poles", task.getDescription());
    }

    // A task must have an ID.
    @Test
    public void testMissingTaskId() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task(null, "Pack tent", "Check tent and poles"));
    }

    // An ID cannot exceed 10 characters.
    @Test
    public void testTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task("CAMPING12345", "Pack tent", "Check tent and poles"));
    }

    // A task must have a name.
    @Test
    public void testMissingTaskName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task("CAMP01", null, "Check tent and poles"));
    }

    // A name cannot exceed 20 characters.
    @Test
    public void testTaskNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task("CAMP01", "Prepare all camping equipment",
                        "Check tent and poles"));
    }

    // A task must have a description.
    @Test
    public void testMissingDescription() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task("CAMP01", "Pack tent", null));
    }

    // A description cannot exceed 50 characters.
    @Test
    public void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task("CAMP01", "Pack tent",
                        "Check every piece of camping equipment before leaving home"));
    }

    // The task name can be changed.
    @Test
    public void testChangeTaskName() {
        Task task = new Task("CAMP01", "Pack tent", "Check tent and poles");

        task.setName("Pack gear");

        assertEquals("Pack gear", task.getName());
    }

    // The task description can be changed.
    @Test
    public void testChangeDescription() {
        Task task = new Task("CAMP01", "Pack tent", "Check tent and poles");

        task.setDescription("Pack tent before Friday");

        assertEquals("Pack tent before Friday", task.getDescription());
    }

    // Invalid name changes should be rejected.
    @Test
    public void testRejectInvalidNameUpdate() {
        Task task = new Task("CAMP01", "Pack tent", "Check tent and poles");

        assertThrows(IllegalArgumentException.class, () ->
                task.setName(null));

        assertThrows(IllegalArgumentException.class, () ->
                task.setName("Prepare all camping equipment"));
    }

    // Invalid description changes should be rejected.
    @Test
    public void testRejectInvalidDescriptionUpdate() {
        Task task = new Task("CAMP01", "Pack tent", "Check tent and poles");

        assertThrows(IllegalArgumentException.class, () ->
                task.setDescription(null));

        assertThrows(IllegalArgumentException.class, () ->
                task.setDescription(
                        "Check every piece of camping equipment before leaving home"));
    }
}