package contactservice;

import java.util.ArrayList;

/*
 * The ContactService class manages contacts stored in memory.
 * It allows contacts to be added, deleted, and updated.
 */
public class ContactService {

    // Stores the contacts while the program is running.
    private ArrayList<Contact> contacts;

    // Creates an empty list for storing contacts.
    public ContactService() {
        contacts = new ArrayList<>();
    }

    // Adds a new contact if the contact ID is not already being used.
    public void addContact(Contact contact) {

        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        // Check the existing contacts for a duplicate ID.
        for (Contact existingContact : contacts) {

            if (existingContact.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID already exists.");
            }
        }

        contacts.add(contact);
    }

    // Deletes a contact using its contact ID.
    public void deleteContact(String contactId) {

        for (int i = 0; i < contacts.size(); i++) {

            if (contacts.get(i).getContactId().equals(contactId)) {
                contacts.remove(i);
                return;
            }
        }

        // An error is returned if the ID does not exist.
        throw new IllegalArgumentException("Contact ID was not found.");
    }

    // Updates the first name of a contact.
    public void updateFirstName(String contactId, String firstName) {

        Contact contact = findContact(contactId);
        contact.setFirstName(firstName);
    }

    // Updates the last name of a contact.
    public void updateLastName(String contactId, String lastName) {

        Contact contact = findContact(contactId);
        contact.setLastName(lastName);
    }

    // Updates the phone number of a contact.
    public void updatePhone(String contactId, String phone) {

        Contact contact = findContact(contactId);
        contact.setPhone(phone);
    }

    // Updates the address of a contact.
    public void updateAddress(String contactId, String address) {

        Contact contact = findContact(contactId);
        contact.setAddress(address);
    }

    // Finds a contact in the list using its contact ID.
    private Contact findContact(String contactId) {

        for (Contact contact : contacts) {

            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }

        throw new IllegalArgumentException("Contact ID was not found.");
    }
}


/* Reference: 
 * García, B. (2017). Mastering software testing with JUnit 5:
 * Comprehensive guide to develop high quality Java applications.
 * Packt Publishing.
 * Youtube Video https://www.youtube.com/watch?v=_OR2HqiVp5A&t=679s
 * AI tools such as ChatGPT and Gemini, help me understand java programming concept, JUnit testing, and the requirement
 * for the contact service project. It assisted in troubleshooting, and explaining the code, and provided guidance
 * while creating and testing my Java classes. I reviewed the generated information, made changes as needed, 
 * and tested the code in Eclipse to make sure it worked correctly.
 */