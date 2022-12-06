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
            Contact savedContact = findContact(contact.getPhoneNumber());
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
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(findContact(contact.getPhoneNumber()));
    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public Contact findById(String phoneNumber) {
        return findContact(phoneNumber);
    }

    private Contact findContact(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        throw new ContactNotFoundException("Contact With id " + phoneNumber + " not found");
    }
}
