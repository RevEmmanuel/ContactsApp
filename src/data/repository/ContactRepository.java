package data.repository;

import data.models.Contact;

public interface ContactRepository {

    Contact save(Contact contact);
    void delete(Contact contact);
    int count();
    Contact findById(String phoneNumber);
}
