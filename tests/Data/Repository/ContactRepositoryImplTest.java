package Data.Repository;

import Data.Models.Contact;
import Exceptions.ContactNotFoundException;
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
    void testThatContactDoesNotHaveIDWhenCreated() {
        Contact myContact = new Contact();
        assertEquals(0, myContact.getId());
    }

    @Test
    void saveContactTotalContactIsOneAndContactIdTest() {
        // when I try to save a contact
        myContactRepository.save(paragonConnect);
        // assert that count is 1
        assertEquals(1, myContactRepository.count());
        // assert that contact now has an id
        assertEquals(1, paragonConnect.getId());
    }

    @Test
    void testThatTwoContactsCanBeSaved() {
        Contact myContact = new Contact();
        // when I try to save two contacts
        myContactRepository.save(paragonConnect);
        myContactRepository.save(myContact);

        // assert that count is 2
        assertEquals(2, myContactRepository.count());
        // assert that contacts have correct id
        assertEquals(1, paragonConnect.getId());
        assertEquals(2, myContact.getId());
    }

    @Test
    void saveContactFindByIdReturnSavedContact() {
        paragonConnect.setFirstName("Cohort");
        paragonConnect.setLastName("-13");
        paragonConnect.setPhoneNumber("08123456789");

        // when I save a new contact and find by id
        myContactRepository.save(paragonConnect);
        Contact savedContact = myContactRepository.findById(1);

        // assert that the contact is equals to saved contact
        assertEquals(paragonConnect, savedContact);
    }

    @Test
    void testThatThrowsExceptionWhenContactIsNotFound() {
        assertThrows(ContactNotFoundException.class, () -> myContactRepository.findById(3));
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
        updatedContact.setId(1);
        updatedContact.setFirstName("Paragons");
        updatedContact.setLastName("Valence");
        updatedContact.setPhoneNumber("08122220222");
        myContactRepository.save(updatedContact);

        // assert that the contact details have been updated
        Contact savedPhoneBook = myContactRepository.findById(1);
        assertEquals(1, myContactRepository.count());
        assertEquals("Paragons", savedPhoneBook.getFirstName());
        assertEquals("Valence", savedPhoneBook.getLastName());
        assertEquals("08122220222", savedPhoneBook.getPhoneNumber());
    }

    @Test
    void testThatContactCanBeDeleted() {
        paragonConnect.setFirstName("Cohort");
        paragonConnect.setLastName("-13");
        paragonConnect.setPhoneNumber("08123456789");
        Contact myContact = new Contact();

        // when I save new contacts
        myContactRepository.save(paragonConnect);
        myContactRepository.save(myContact);
        assertEquals(2, myContactRepository.count());
        // and I delete a contact
        myContactRepository.delete(paragonConnect);

        // check that contact cannot be found
        assertThrows(ContactNotFoundException.class, () -> myContactRepository.findById(paragonConnect.getId()));
        // and that sie has decreased
        assertEquals(1, myContactRepository.count());
        assertEquals(myContact, myContactRepository.findById(2));
    }
}