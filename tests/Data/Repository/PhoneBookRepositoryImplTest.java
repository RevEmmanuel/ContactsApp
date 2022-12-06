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
        // when I try to save a contact
        myPhoneBookRepository.save(paragons);
        // assert that count is 1
        assertEquals(1, myPhoneBookRepository.count());
    }
}
