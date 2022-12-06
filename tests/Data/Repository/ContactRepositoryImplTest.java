package Data.Repository;

import Data.Models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {

    private ContactRepository myContactRepository;
    private Contact paragonConnect;

    @BeforeEach
    void setUp() {
        myContactRepository = new ContactRepositoryImpl();
        paragonConnect = new Contact();
    }
}