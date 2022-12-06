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
        // when I save a new phonebook and find by id
        paragons.setOwnerName("Cohort13");
        paragons.setPhoneNumber("08123456789");
        myPhoneBookRepository.save(paragons);
        Phonebook savedPhoneBook = myPhoneBookRepository.findById("08123456789"); // phone number is the id

        // assert that the phonebook is equals to saved phonebook
        assertEquals(paragons, savedPhoneBook);
    }
}
