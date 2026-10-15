package appointmentservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

// This class tests the functions provided by AppointmentService.
public class AppointmentServiceTest {

    // Creates an appointment with a future date for use in the service tests.
    private Appointment createAppointment(String id) {

        // Creates a date one day in the future.
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        // Creates and returns an appointment using the provided ID.
        return new Appointment(
                id,
                futureDate,
                "Routine appointment"
        );
    }

    // Tests that the service can add a valid appointment.
    @Test
    public void testAddAppointment() {

        // Creates a new appointment service.
        AppointmentService service = new AppointmentService();

        // Creates an appointment with a unique ID.
        Appointment appointment = createAppointment("A100");

        // Adds the appointment to the service.
        service.addAppointment(appointment);

        // Tries to delete the appointment to confirm that it was added.
        assertDoesNotThrow(() -> service.deleteAppointment("A100"));
    }

    // Tests that the service does not allow duplicate appointment IDs.
    @Test
    public void testDuplicateAppointmentIdIsRejected() {

        // Creates a new appointment service.
        AppointmentService service = new AppointmentService();

        // Creates two appointments using the same ID.
        Appointment first = createAppointment("A101");
        Appointment second = createAppointment("A101");

        // Adds the first appointment to the service.
        service.addAppointment(first);

        // Checks that adding another appointment with the same ID causes an error.
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(second);
        });
    }

    // Tests that an appointment can be deleted by its ID.
    @Test
    public void testDeleteAppointment() {

        // Creates a new appointment service.
        AppointmentService service = new AppointmentService();

        // Creates an appointment for the test.
        Appointment appointment = createAppointment("A102");

        // Adds the appointment before trying to delete it.
        service.addAppointment(appointment);

        // Deletes the appointment using its ID.
        service.deleteAppointment("A102");

        // Checks that the appointment no longer exists.
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("A102");
        });
    }

    // Tests that the service reports an error when deleting an appointment that does not exist.
    @Test
    public void testDeleteNonexistentAppointment() {

        // Creates an empty appointment service.
        AppointmentService service = new AppointmentService();

        // Attempts to delete an appointment that was never added.
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("DOESNOTEXIST");
        });
    }

    // Tests that a null appointment cannot be added to the service.
    @Test
    public void testNullAppointmentCannotBeAdded() {

        // Creates a new appointment service.
        AppointmentService service = new AppointmentService();

        // Checks that adding a null appointment causes an error.
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(null);
        });
    }
}