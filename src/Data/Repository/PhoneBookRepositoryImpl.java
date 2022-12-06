package Data.Repository;

import Data.Models.Phonebook;

import java.util.ArrayList;

public class PhoneBookRepositoryImpl implements PhoneBookRepository {

    private final ArrayList<Phonebook> phonebooks = new ArrayList<>();

    @Override
    public Phonebook save(Phonebook phonebook) {
        phonebooks.add(phonebook);
        return phonebook;
    }

    @Override
    public void delete(Phonebook phonebook) {

    }

    @Override
    public int count() {
        return phonebooks.size();
    }
}
