package data.repository;

import data.models.Contact;
import exceptions.ContactNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {

    private ContactRepository myContactRepository;
    private Contact paragonConnect;

    @BeforeEach
    void setUp() {
        // given that I have a contact and a contact repository
        myContactRepository = new ContactRepositoryImpl();
        paragonConnect = new Contact();
    }

    @Test
    void saveContactTotalContactIsOneTest() {
        // when I try to save a contact
        myContactRepository.save(paragonConnect);
        // assert that count is 1
        assertEquals(1, myContactRepository.count());
    }

    @Test
    void saveContactFindByIdReturnSavedContact() {
        paragonConnect.setFirstName("Cohort");
        paragonConnect.setLastName("-13");
        paragonConnect.setPhoneNumber("08123456789");

        // when I save a new contact and find by id
        myContactRepository.save(paragonConnect);
        Contact savedContact = myContactRepository.findById("08123456789");

        // assert that the contact is equals to saved contact
        assertEquals(paragonConnect, savedContact);
    }

    @Test
    void testThatThrowsExceptionWhenContactIsNotFound() {
        assertThrows(ContactNotFoundException.class, () -> myContactRepository.findById("12345"));
    }

    @Test
    void updateContactInformationByIdReturnUpdatedContactTest() {
        paragonConnect.setFirstName("Cohort");
        paragonConnect.setLastName("-13");
        paragonConnect.setPhoneNumber("08123456789");

        // when I save a new contact
        myContactRepository.save(paragonConnect);
        assertEquals(1, myContactRepository.count());
        // and update the details
        Contact updatedContact = new Contact();
        updatedContact.setFirstName("Paragons");
        updatedContact.setLastName("Valence");
        updatedContact.setPhoneNumber("08123456789");
        myContactRepository.save(updatedContact);

        // assert that the contact details have been updated
        Contact savedPhoneBook = myContactRepository.findById("08123456789");
        assertEquals(1, myContactRepository.count());
        assertEquals("Paragons", savedPhoneBook.getFirstName());
        assertEquals("Valence", savedPhoneBook.getLastName());
        assertEquals("08123456789", savedPhoneBook.getPhoneNumber());
    }

    @Test
    void testThatContactCanBeDeleted() {
        paragonConnect.setFirstName("Cohort");
        paragonConnect.setLastName("-13");
        paragonConnect.setPhoneNumber("08123456789");
        Contact myContact = new Contact();
        myContact.setPhoneNumber("081222202222");
        myContact.setFirstName("Paragon");
        myContact.setLastName("Valence");

        // when I save new contacts
        myContactRepository.save(paragonConnect);
        myContactRepository.save(myContact);
        assertEquals(2, myContactRepository.count());
        // and I delete a contact
        myContactRepository.delete(paragonConnect);

        // check that contact cannot be found
        assertThrows(ContactNotFoundException.class, () -> myContactRepository.findById(paragonConnect.getPhoneNumber()));
        // and that size has decreased
        assertEquals(1, myContactRepository.count());
        assertEquals(myContact, myContactRepository.findById(myContact.getPhoneNumber()));
    }
}