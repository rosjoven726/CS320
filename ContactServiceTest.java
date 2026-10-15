/*
 * This class tests the ContactService to make sure contacts
 * can be added, deleted, and updated according to the requirements.
 *
 * Reference:
 * García, B. (2017). Mastering Software Testing with JUnit 5:
 * Comprehensive Guide to Develop High Quality Java Applications.
 * Packt Publishing.
 */
package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    // Tests that a contact can be added to the service.
    @Test
    public void testAddContact() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "C001",
                "Joven",
                "Rosales",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        // Updating the contact verifies that it was successfully stored.
        service.updateFirstName("C001", "John");

        assertEquals("John", contact.getFirstName());
    }

    // Tests that two contacts cannot have the same contact ID.
    @Test
    public void testDuplicateContactId() {

        ContactService service = new ContactService();

        Contact firstContact = new Contact(
                "C001",
                "Joven",
                "Rosales",
                "1234567890",
                "123 Main Street"
        );

        Contact secondContact = new Contact(
                "C001",
                "John",
                "Smith",
                "9876543210",
                "456 Oak Street"
        );

        service.addContact(firstContact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(secondContact);
        });
    }

    // Tests that a contact can be deleted using its ID.
    @Test
    public void testDeleteContact() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "C001",
                "Joven",
                "Rosales",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        service.deleteContact("C001");

        // The deleted contact should no longer be found.
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("C001", "John");
        });
    }

    // Tests that the first name can be updated.
    @Test
    public void testUpdateFirstName() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "C002",
                "Joven",
                "Rosales",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        service.updateFirstName("C002", "Michael");

        assertEquals("Michael", contact.getFirstName());
    }

    // Tests that the last name can be updated.
    @Test
    public void testUpdateLastName() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "C003",
                "Joven",
                "Rosales",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        service.updateLastName("C003", "Johnson");

        assertEquals("Johnson", contact.getLastName());
    }

    // Tests that the phone number can be updated.
    @Test
    public void testUpdatePhone() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "C004",
                "Joven",
                "Rosales",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        service.updatePhone("C004", "9876543210");

        assertEquals("9876543210", contact.getPhone());
    }

    // Tests that the address can be updated.
    @Test
    public void testUpdateAddress() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "C005",
                "Joven",
                "Rosales",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        service.updateAddress("C005", "456 Oak Street");

        assertEquals("456 Oak Street", contact.getAddress());
    }

    // Tests that an updated first name cannot be longer than 10 characters.
    @Test
    public void testUpdateFirstNameTooLong() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "C006",
                "Joven",
                "Rosales",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("C006", "Christopher");
        });
    }

    // Tests that an updated phone number must contain exactly 10 digits.
    @Test
    public void testUpdatePhoneWithInvalidNumber() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "C007",
                "Joven",
                "Rosales",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("C007", "12345");
        });
    }

    // Tests that an updated address cannot be longer than 30 characters.
    @Test
    public void testUpdateAddressTooLong() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "C008",
                "Joven",
                "Rosales",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress(
                    "C008",
                    "1234567890123456789012345678901"
            );
        });
    }

    // Tests that deleting a contact ID that does not exist produces an error.
    @Test
    public void testDeleteContactThatDoesNotExist() {

        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("C999");
        });
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
