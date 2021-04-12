package com.example.testtask.service;

import com.example.testtask.model.Contact;
import com.example.testtask.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private final ContactRepository repo;

    @Autowired
    public ContactService(@Qualifier("fakeContact") ContactRepository repo) {
        this.repo = repo;
    }

    public Long addContact(Contact contact) {
        return this.repo.insertContact(contact);
    }

    public List<Contact> getAllContacts() {
        return this.repo.getAllContacts();
    }

    public Optional<Contact> getContactById(Long id) {
        return this.repo.getContactById(id);
    }

    public int deleteContactById(Long id) {
        return this.repo.deleteContactById(id);
    }

    public int updateContactById(Long id, Contact contact) {
        return this.repo.updateContactById(id, contact);
    }
}
