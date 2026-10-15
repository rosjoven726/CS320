/* CS320 Module 3 Assignment 
 * By Joven Rosales
 * Date: 9/21/2026
 */
package contactservice;

/*
 * The Contact class stores the information for one contact.
 * Each contact has an ID, first name, last name, phone number,
 * and address.
 */
public class Contact {

    // The contact ID is final so it cannot be changed after creation.
    private final String contactId;

    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /*
     * Creates a new contact and checks that all required information
     * follows the requirements before storing it.
     */
    public Contact(String contactId, String firstName, String lastName,
                   String phone, String address) {

        checkContactId(contactId);
        checkName(firstName, "First name");
        checkName(lastName, "Last name");
        checkPhone(phone);
        checkAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Checks that the contact ID is not null and is no longer than 10 characters.
    private void checkContactId(String contactId) {

        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException(
                    "Contact ID must be 10 characters or less."
            );
        }
    }

    // Checks that a first or last name is not null and is no longer than 10 characters.
    private void checkName(String name, String nameType) {

        if (name == null || name.length() > 10) {
            throw new IllegalArgumentException(
                    nameType + " must be 10 characters or less."
            );
        }
    }

    // Checks that the phone number contains exactly 10 digits.
    private void checkPhone(String phone) {

        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                    "Phone number must contain exactly 10 digits."
            );
        }
    }

    // Checks that the address is not null and is no longer than 30 characters.
    private void checkAddress(String address) {

        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
                    "Address must be 30 characters or less."
            );
        }
    }

    // Returns the contact ID.
    public String getContactId() {
        return contactId;
    }

    // Returns the first name.
    public String getFirstName() {
        return firstName;
    }

    // Updates the first name after checking that it is valid.
    public void setFirstName(String firstName) {

        checkName(firstName, "First name");
        this.firstName = firstName;
    }

    // Returns the last name.
    public String getLastName() {
        return lastName;
    }

    // Updates the last name after checking that it is valid.
    public void setLastName(String lastName) {

        checkName(lastName, "Last name");
        this.lastName = lastName;
    }

    // Returns the phone number.
    public String getPhone() {
        return phone;
    }

    // Updates the phone number after checking that it is valid.
    public void setPhone(String phone) {

        checkPhone(phone);
        this.phone = phone;
    }

    // Returns the address.
    public String getAddress() {
        return address;
    }

    // Updates the address after checking that it is valid.
    public void setAddress(String address) {

        checkAddress(address);
        this.address = address;
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