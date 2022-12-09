package Services;

import Data.Models.Contact;
import Data.Models.Phonebook;
import Data.Repository.PhoneBookRepository;
import Data.Repository.PhoneBookRepositoryImpl;
import Exceptions.PhonebookNotFoundException;

public class PhoneBookServiceImpl implements PhoneBookService {

    PhoneBookRepository phoneBookRepository = new PhoneBookRepositoryImpl();

    @Override
    public void register(String ownerName, String ownerPhoneNumber) {
        // check if phonebook exists already
        if (userExists(ownerPhoneNumber)) throw new IllegalArgumentException("Phonebook already exists");
        // create a new phonebook
        Phonebook newPhoneBook = new Phonebook();
        newPhoneBook.setOwnerName(ownerName);
        newPhoneBook.setOwnerPhoneNumber(ownerPhoneNumber);

        // save phonebook
        phoneBookRepository.save(newPhoneBook);
    }

    private boolean userExists(String phoneNumber) {
        try {
            Phonebook foundPhonebook = phoneBookRepository.findById(phoneNumber);
        }
        catch (PhonebookNotFoundException e) {
            return false;
        }
        return true;
    }

    @Override
    public int countNumberOfUsers() {
        return phoneBookRepository.count();
    }

    @Override
    public void addContact(String ownerPhoneNumber, String firstName, String lastName, String phoneNumber) {

    }

    @Override
    public Contact findContact(String ownerPhoneNumber, String phoneNumberToFind) {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public void updateContact() {

    }
}
