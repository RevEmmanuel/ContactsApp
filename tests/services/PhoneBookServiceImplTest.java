package services;

import dtos.requests.PhoneBookRequest;
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
        PhoneBookRequest phoneBookRequest = new PhoneBookRequest();
        phoneBookRequest.setOwnerName("Cohort 13");
        phoneBookRequest.setOwnerPhoneNumber("08123456789");
        phoneBookService.register(phoneBookRequest);
        assertEquals(1, phoneBookService.countNumberOfUsers());
    }

    @Test
    void testThatRegisteringDuplicateUserFails() {
        PhoneBookRequest phoneBookRequest = new PhoneBookRequest();
        phoneBookRequest.setOwnerName("Cohort 13");
        phoneBookRequest.setOwnerPhoneNumber("08123456789");
        phoneBookService.register(phoneBookRequest);

        PhoneBookRequest phoneBookRequest2 = new PhoneBookRequest();
        phoneBookRequest2.setOwnerName("Paragons");
        phoneBookRequest2.setOwnerPhoneNumber("08123456789");
        assertThrows(IllegalArgumentException.class, () -> phoneBookService.register(phoneBookRequest2));
    }
}