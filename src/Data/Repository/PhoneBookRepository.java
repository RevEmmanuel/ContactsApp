package Data.Repository;

import Data.Models.Phonebook;

public interface PhoneBookRepository {

    Phonebook save(Phonebook phonebook);
    void delete(Phonebook phonebook);
    int count();
}
