package appointmentservice;

import java.util.Date;

// This class represents an appointment in the mobile application.
public class Appointment {

    // Stores the unique appointment ID.
    // The final keyword prevents the ID from being changed after creation.
    private final String appointmentId;

    // Stores the date and time of the appointment.
    private Date appointmentDate;

    // Stores the description of the appointment.
    private String description;

    // Creates a new appointment using the ID, date, and description.
    public Appointment(String appointmentId, Date appointmentDate, String description) {

        // Checks that the appointment ID is not null and is no longer than 10 characters.
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID is invalid.");
        }

        // Checks that the appointment date exists and is not in the past.
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date is invalid.");
        }

        // Checks that the description exists and is no longer than 50 characters.
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description is invalid.");
        }

        // Saves the valid appointment information.
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Returns the appointment ID.
    public String getAppointmentId() {
        return appointmentId;
    }

    // Returns the current appointment date.
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    // Updates the appointment date.
    public void setAppointmentDate(Date appointmentDate) {

        // Makes sure the new date is not null or in the past.
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date is invalid.");
        }

        // Saves the new appointment date.
        this.appointmentDate = appointmentDate;
    }

    // Returns the current appointment description.
    public String getDescription() {
        return description;
    }

    // Updates the appointment description.
    public void setDescription(String description) {

        // Makes sure the new description is not null or longer than 50 characters.
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description is invalid.");
        }

        // Saves the new description.
        this.description = description;
    }
}
