package Data.Repository;

import Data.Models.Phonebook;
import Exceptions.PhonebookNotFoundException;

import java.util.ArrayList;

public class PhoneBookRepositoryImpl implements PhoneBookRepository {

    private final ArrayList<Phonebook> phoneBooks = new ArrayList<>();

    @Override
    public Phonebook save(Phonebook phonebook) {
        phoneBooks.add(phonebook);
        return phonebook;
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
            if (phoneBook.getPhoneNumber().equals(phoneNumber)) {
                return phoneBook;
            }
        }
        throw new PhonebookNotFoundException("PhoneBook With Number " + phoneNumber + " not found");
    }
}
