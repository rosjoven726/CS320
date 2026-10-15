package appointmentservice;

import java.util.ArrayList;
import java.util.List;

// This class manages appointments while the application is running.
public class AppointmentService {

    // Stores the appointment objects in memory.
    private List<Appointment> appointments = new ArrayList<>();

    // Adds a new appointment to the service.
    public void addAppointment(Appointment appointment) {

        // Makes sure an empty appointment cannot be added.
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }

        // Checks the existing appointments for a duplicate ID.
        for (Appointment existing : appointments) {

            // Compares the new appointment ID with the existing ID.
            if (existing.getAppointmentId().equals(appointment.getAppointmentId())) {

                // Stops the appointment from being added if the ID already exists.
                throw new IllegalArgumentException("Appointment ID already exists.");
            }
        }

        // Adds the appointment after all of the checks pass.
        appointments.add(appointment);
    }

    // Deletes an appointment using its appointment ID.
    public void deleteAppointment(String appointmentId) {

        // Goes through the appointments stored in the service.
        for (int i = 0; i < appointments.size(); i++) {

            // Checks whether the current appointment has the requested ID.
            if (appointments.get(i).getAppointmentId().equals(appointmentId)) {

                // Removes the appointment when the matching ID is found.
                appointments.remove(i);
                return;
            }
        }

        // Reports an error when the requested appointment does not exist.
        throw new IllegalArgumentException("Appointment ID was not found.");
    }
}
