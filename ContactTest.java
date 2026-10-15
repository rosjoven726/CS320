package contactservice;

/*
 * This class tests the Contact class to make sure it follows
 * the requirements for creating and updating contact information.
 *
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    // Tests that a contact can be created with valid information.
    @Test
    public void testValidContactCreation() {

        Contact contact = new Contact(
                "C001",
                "Joven",
                "Rosales",
                "1234567890",
                "123 Main Street"
        );

        assertEquals("C001", contact.getContactId());
        assertEquals("Joven", contact.getFirstName());
        assertEquals("Rosales", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    // Tests that a contact cannot be created without a contact ID.
    @Test
    public void testContactIdCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    null,
                    "John",
                    "Smith",
                    "1234567890",
                    "123 Main Street"
            );
        });
    }

    // Tests that the contact ID cannot be longer than 10 characters.
    @Test
    public void testContactIdCannotBeLongerThan10Characters() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345678901",
                    "John",
                    "Smith",
                    "1234567890",
                    "123 Main Street"
            );
        });
    }

    // Tests that the first name cannot be null.
    @Test
    public void testFirstNameCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    null,
                    "Smith",
                    "1234567890",
                    "123 Main Street"
            );
        });
    }

    // Tests that the first name cannot be longer than 10 characters.
    @Test
    public void testFirstNameCannotBeLongerThan10Characters() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Christopher",
                    "Smith",
                    "1234567890",
                    "123 Main Street"
            );
        });
    }

    // Tests that the last name cannot be null.
    @Test
    public void testLastNameCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    null,
                    "1234567890",
                    "123 Main Street"
            );
        });
    }

    // Tests that the last name cannot be longer than 10 characters.
    @Test
    public void testLastNameCannotBeLongerThan10Characters() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Andersonson",
                    "1234567890",
                    "123 Main Street"
            );
        });
    }

    // Tests that the phone number cannot be null.
    @Test
    public void testPhoneCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    null,
                    "123 Main Street"
            );
        });
    }

    // Tests that the phone number must contain exactly 10 digits.
    @Test
    public void testPhoneMustBeExactly10Digits() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "12345",
                    "123 Main Street"
            );
        });
    }

    // Tests that the address cannot be null.
    @Test
    public void testAddressCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "1234567890",
                    null
            );
        });
    }

    // Tests that the address cannot be longer than 30 characters.
    @Test
    public void testAddressCannotBeLongerThan30Characters() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "1234567890",
                    "1234567890123456789012345678901"
            );
        });
    }

    // Tests that the contact ID stays the same after other fields are updated.
    @Test
    public void testContactIdCannotBeUpdated() {

        Contact contact = new Contact(
                "C001",
                "Joven",
                "Rosales",
                "1234567890",
                "123 Main Street"
        );

        contact.setFirstName("John");
        contact.setLastName("Smith");
        contact.setPhone("9876543210");
        contact.setAddress("456 Oak Street");

        assertEquals("C001", contact.getContactId());
    }

    // Tests that the phone number cannot contain letters.
    @Test
    public void testPhoneMustContainOnlyDigits() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "C009",
                    "Joven",
                    "Rosales",
                    "123456789A",
                    "123 Main Street"
            );
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