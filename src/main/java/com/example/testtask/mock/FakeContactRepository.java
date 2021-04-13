package com.example.testtask.mock;

import com.example.testtask.model.Contact;
import com.example.testtask.repository.ContactRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeContact")
public class FakeContactRepository implements ContactRepository {
    private static Long latestId = 0L;
    private static List<Contact> Db = new ArrayList<>();

    public Long insertContact(Contact contact) {
        contact.setId(++latestId);
        Db.add(contact);
        return latestId;
    }

    public List<Contact> getAllContacts() {
        return Db;
    }

    public Optional<Contact> getContactById(Long id) {
        return Db.stream()
                .filter(contact -> contact.getId().equals(id))
                .findFirst();
    }

    public int deleteContactById(Long id) {
        Optional<Contact> contact = this.getContactById(id);
        if (!contact.isPresent()) return 0;
        Db.remove(contact.get());
        return 1;
    }

    public int updateContactById(Long id, Contact contactToUpdate) {
        return getContactById(id)
                .map(c -> {
                    int index = Db.indexOf(c);
                    if (index >= 0) {
                        contactToUpdate.setId(id);
                        Db.set(index, contactToUpdate);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    public <S extends Contact> S save(S s) {
        return null;
    }

    public <S extends Contact> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    public Optional<Contact> findById(Long aLong) {
        return Optional.empty();
    }

    public boolean existsById(Long aLong) {
        return false;
    }

    public Iterable<Contact> findAll() {
        return null;
    }

    public Iterable<Contact> findAllById(Iterable<Long> iterable) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteById(Long aLong) {

    }

    public void delete(Contact contact) {

    }

    public void deleteAll(Iterable<? extends Contact> iterable) {

    }

    public void deleteAll() {

    }
}
