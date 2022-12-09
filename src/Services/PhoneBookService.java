package Services;

import Data.Models.Contact;

public interface PhoneBookService {

    void register(String ownerName, String ownerPhoneNumber);

    void addContact(String ownerPhoneNumber, String firstName, String lastName, String phoneNumber);

    Contact findContact(String ownerPhoneNumber, String phoneNumberToFind);

    void delete();

    void updateContact();

    int countNumberOfUsers();
}
