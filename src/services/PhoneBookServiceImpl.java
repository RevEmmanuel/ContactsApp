package services;

import data.models.Contact;
import data.models.Phonebook;
import data.repository.PhoneBookRepository;
import data.repository.PhoneBookRepositoryImpl;
import dtos.requests.ContactRequest;
import exceptions.PhonebookNotFoundException;
import dtos.requests.PhoneBookRequest;

public class PhoneBookServiceImpl implements PhoneBookService {

    PhoneBookRepository phoneBookRepository = new PhoneBookRepositoryImpl();

    @Override
    public void register(PhoneBookRequest phoneBookRequest) {
        // check if phonebook exists already
        if (userExists(phoneBookRequest.getOwnerPhoneNumber())) throw new IllegalArgumentException("Phonebook already exists");
        // create a new phonebook
        Phonebook newPhoneBook = new Phonebook();
        newPhoneBook.setOwnerName(phoneBookRequest.getOwnerName());
        newPhoneBook.setOwnerPhoneNumber(phoneBookRequest.getOwnerPhoneNumber());

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
    public void addContact(String ownerPhoneNumber, ContactRequest contactRequest) {
//        findPhoneBook(ownerPhoneNumber).
    }

    @Override
    public Contact findContact(String ownerPhoneNumber, String phoneNumberToFind) {
        return null;
    }

    @Override
    public void deleteNumber(String ownerPhoneNumber, String phoneNumberToDelete) {

    }

    @Override
    public void updateContact(String ownerPhoneNumber, ContactRequest contactRequest) {

    }

    private Phonebook findPhoneBook(String ownerPhoneNumber) {
        for (Phonebook phoneBook : phoneBookRepository.getPhoneBook()) if (phoneBook.getOwnerPhoneNumber().equals(ownerPhoneNumber)) return phoneBook;
        throw new PhonebookNotFoundException("Phonebook not found");
    }

}
