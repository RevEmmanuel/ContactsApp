package services;

import data.models.Contact;
import dtos.requests.ContactRequest;
import dtos.requests.PhoneBookRequest;

public interface PhoneBookService {

    void register(PhoneBookRequest phoneBookRequest);

    void addContact(String ownerPhoneNumber, ContactRequest contactRequest);

    Contact findContact(String ownerPhoneNumber, String phoneNumberToFind);

    void deleteNumber(String ownerPhoneNumber, String phoneNumberToDelete);

    void updateContact(String ownerPhoneNumber, ContactRequest contactRequest);

    int countNumberOfUsers();
}
