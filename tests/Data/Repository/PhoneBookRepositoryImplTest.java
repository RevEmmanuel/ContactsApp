package Data.Repository;

import Data.Models.Phonebook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhoneBookRepositoryImplTest {

    private PhoneBookRepository myPhoneBookRepository;
    private Phonebook paragons;

    @BeforeEach
    void setUp() {
        // given I have a phonebook repository and a phonebook
        myPhoneBookRepository = new PhoneBookRepositoryImpl();
        paragons = new Phonebook();
    }

    @Test
    void savePhoneBookTotalPhoneBookIsOneTest() {
        // when I try to save a phonebook
        myPhoneBookRepository.save(paragons);
        // assert that count is 1
        assertEquals(1, myPhoneBookRepository.count());
    }

    @Test
    void savePhoneBookFindByIdReturnSavedPhoneBook() {
        paragons.setOwnerName("Cohort13");
        paragons.setOwnerPhoneNumber("08123456789");

        // when I save a new phonebook and find by id
        myPhoneBookRepository.save(paragons);
        Phonebook savedPhoneBook = myPhoneBookRepository.findById("08123456789"); // phone number is the id

        // assert that the phonebook is equals to saved phonebook
        assertEquals(paragons, savedPhoneBook);
    }

    @Test
    void updatePhoneBookInformationByIdReturnUpdatedPhoneBookTest() {
        paragons.setOwnerName("Cohort13");
        paragons.setOwnerPhoneNumber("08123456789");

        // when I save a new phonebook
        myPhoneBookRepository.save(paragons);
        // and update the details
        Phonebook updatedPhoneBook = new Phonebook();
        updatedPhoneBook.setOwnerName("Paragons");
        updatedPhoneBook.setOwnerPhoneNumber("08123456789");
        myPhoneBookRepository.save(updatedPhoneBook);

        // assert that the phonebook details have been updated
        Phonebook savedPhoneBook = myPhoneBookRepository.findById("08123456789");
        assertEquals(1, myPhoneBookRepository.count());
        assertEquals("Paragons", savedPhoneBook.getOwnerName());
    }
}
