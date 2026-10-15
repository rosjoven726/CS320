package appointmentservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

// This class tests the requirements of the Appointment object.
public class AppointmentTest {

    // Creates a valid appointment that can be reused by multiple tests.
    private Appointment createValidAppointment() {

        // Creates a date one day in the future.
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        // Returns an appointment containing valid information.
        return new Appointment(
                "A001",
                futureDate,
                "Doctor appointment"
        );
    }

    // Tests that an appointment can be created with valid information.
    @Test
    public void testValidAppointment() {

        // Creates a valid appointment for the test.
        Appointment appointment = createValidAppointment();

        // Checks that the appointment ID was stored correctly.
        assertEquals("A001", appointment.getAppointmentId());

        // Checks that the description was stored correctly.
        assertEquals("Doctor appointment", appointment.getDescription());

        // Checks that the appointment date is not null.
        assertNotNull(appointment.getAppointmentDate());
    }

    // Tests that the appointment ID cannot be null.
    @Test
    public void testAppointmentIdCannotBeNull() {

        // Creates a future date for the appointment.
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        // Checks that creating an appointment with a null ID causes an error.
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Doctor appointment");
        });
    }

    // Tests that the appointment ID cannot be longer than 10 characters.
    @Test
    public void testAppointmentIdCannotBeTooLong() {

        // Creates a future date for the appointment.
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        // Uses an ID that is longer than the allowed 10 characters.
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("APPOINTMENT11", futureDate, "Doctor appointment");
        });
    }

    // Tests that the appointment date cannot be null.
    @Test
    public void testAppointmentDateCannotBeNull() {

        // Checks that a null appointment date causes an error.
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A002", null, "Doctor appointment");
        });
    }

    // Tests that an appointment date cannot be in the past.
    @Test
    public void testAppointmentDateCannotBeInPast() {

        // Creates a date one day in the past.
        Date pastDate = new Date(System.currentTimeMillis() - 86400000);

        // Checks that the past date causes an error.
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A003", pastDate, "Doctor appointment");
        });
    }

    // Tests that the appointment description cannot be null.
    @Test
    public void testDescriptionCannotBeNull() {

        // Creates a future date for the appointment.
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        // Checks that a null description causes an error.
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A004", futureDate, null);
        });
    }

    // Tests that the appointment description cannot be longer than 50 characters.
    @Test
    public void testDescriptionCannotBeTooLong() {

        // Creates a future date for the appointment.
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        // Creates a description that is longer than the allowed limit.
        String longDescription =
                "This description is intentionally longer than fifty characters.";

        // Checks that the long description causes an error.
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A005", futureDate, longDescription);
        });
    }

    // Tests that the appointment description can be updated.
    @Test
    public void testDescriptionCanBeUpdated() {

        // Creates a valid appointment.
        Appointment appointment = createValidAppointment();

        // Changes the appointment description.
        appointment.setDescription("Updated appointment");

        // Checks that the new description was saved.
        assertEquals("Updated appointment", appointment.getDescription());
    }

    // Tests that the appointment date can be updated.
    @Test
    public void testAppointmentDateCanBeUpdated() {

        // Creates a valid appointment.
        Appointment appointment = createValidAppointment();

        // Creates another date that is in the future.
        Date newDate = new Date(System.currentTimeMillis() + 172800000);

        // Changes the appointment to the new date.
        appointment.setAppointmentDate(newDate);

        // Checks that the new date was saved.
        assertEquals(newDate, appointment.getAppointmentDate());
    }
} 