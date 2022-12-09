package Services;

import Data.Models.Contact;

public interface PhoneBookService {

    void register();

    void addContact();

    Contact findContact();

    void delete();

    void updateContact();
}
