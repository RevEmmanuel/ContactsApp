package services;

import dtos.requests.ContactRequest;

public interface ContactService {

    void countNumberOfContacts();

    void saveContact(ContactRequest contactRequest);




}
