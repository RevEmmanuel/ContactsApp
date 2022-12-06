package Data.Models;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {

    private String ownerName;
    private String phoneNumber;
    private final List<Contact> contacts = new ArrayList<>();

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
