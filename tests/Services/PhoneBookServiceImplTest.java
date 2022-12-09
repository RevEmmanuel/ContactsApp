package Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookServiceImplTest {

    private PhoneBookService phoneBookService;

    @BeforeEach
    void setUp() {
        phoneBookService = new PhoneBookServiceImpl();
    }

    @Test
    void registerUserTest() {
        phoneBookService.register("Cohort 13", "08123456789");
        assertEquals(1, phoneBookService.countNumberOfUsers());
    }

    @Test
    void testThatRegisteringDuplicateUserFails() {
        phoneBookService.register("Cohort 13", "08123456789");
        assertThrows(IllegalArgumentException.class, () -> phoneBookService.register("Paragons", "08123456789"));
    }
}