package Data.Repository;

import Data.Models.Phonebook;
import Exceptions.PhonebookNotFoundException;
import java.util.ArrayList;

public class PhoneBookRepositoryImpl implements PhoneBookRepository {

    private final ArrayList<Phonebook> phoneBooks = new ArrayList<>();

    @Override
    public Phonebook save(Phonebook phoneBook) {
        try {
            // check if the phonebook exists already
            Phonebook savedPhoneBook = findPhoneBook(phoneBook.getOwnerPhoneNumber());
            // if true, then update the phonebook details
            updatePhoneBook(savedPhoneBook, phoneBook);
        }
        catch (PhonebookNotFoundException phonebookNotFound) {
            // else save new phonebook
            phoneBooks.add(phoneBook);
        }
        return phoneBook;
    }

    private void updatePhoneBook(Phonebook update, Phonebook phoneBook) {
        update.setOwnerName(phoneBook.getOwnerName());
        update.setContacts(phoneBook.getContacts());
    }

    @Override
    public void delete(Phonebook phonebook) {

    }

    @Override
    public int count() {
        return phoneBooks.size();
    }

    @Override
    public Phonebook findById(String phoneNumber) {
        return findPhoneBook(phoneNumber);
    }

    private Phonebook findPhoneBook(String phoneNumber) {
        for (Phonebook phoneBook : phoneBooks) {
            if (phoneBook.getOwnerPhoneNumber().equals(phoneNumber)) {
                return phoneBook;
            }
        }
        throw new PhonebookNotFoundException("PhoneBook With Number " + phoneNumber + " not found");
    }
}
