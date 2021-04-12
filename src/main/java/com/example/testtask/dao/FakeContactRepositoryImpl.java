package com.example.testtask.dao;

import com.example.testtask.model.Contact;
import com.example.testtask.repository.ContactRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeContact")
public class FakeContactRepositoryImpl implements ContactRepository {
    private static Long latestId = 0L;
    private static List<Contact> DB = new ArrayList();

    public Long insertContact(Contact contact) {
        contact.setId(++latestId);
        DB.add(contact);
        return latestId;
    }

    @Override
    public List<Contact> getAllContacts() {
        return DB;
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return DB.stream()
                .filter(contact -> contact.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteContactById(Long id) {
        Optional<Contact> contact = this.getContactById(id);
        if (!contact.isPresent()) return 0;
        DB.remove(contact.get());
        return 1;
    }

    @Override
    public int updateContactById(Long id, Contact contactToUpdate) {
        return getContactById(id)
                .map(c -> {
                    int index = DB.indexOf(c);
                    if (index >= 0) {
                        contactToUpdate.setId(id);
                        DB.set(index, contactToUpdate);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
