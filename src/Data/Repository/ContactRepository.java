package Data.Repository;

import Data.Models.Contact;
import Data.Models.Phonebook;

public interface ContactRepository {

    Contact save(Contact contact);
    void delete(Contact contact);
    int count();

    Contact findById(int id);
}
