package Data.Repository;

import Data.Models.Contact;
import Exceptions.ContactNotFoundException;
import java.util.ArrayList;

public class ContactRepositoryImpl implements ContactRepository {

    private final ArrayList<Contact> contacts = new ArrayList<>();
    @Override
    public Contact save(Contact contact) {
        try {
            // check if the phonebook exists already
            Contact savedContact = findContact(contact.getId());
            // if true, then update the phonebook details
            updateContact(savedContact, contact);
        }
        catch (ContactNotFoundException contactNotFound) {
            // else save new phonebook
            contacts.add(contact);
        }
        return contact;
    }

    private void updateContact(Contact update, Contact contact) {
        update.setFirstName(contact.getFirstName());
        update.setLastName(contact.getLastName());
        update.setPhoneNumber(contact.getPhoneNumber());
    }

    @Override
    public void delete(Contact contact) {

    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public Contact findById(int id) {
        return findContact(id);
    }

    private Contact findContact(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        throw new ContactNotFoundException("Contact With id " + id + " not found");
    }
}
