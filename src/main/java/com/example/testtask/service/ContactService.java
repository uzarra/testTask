package com.example.testtask.service;

import com.example.testtask.model.Contact;
import com.example.testtask.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {
    private final ContactRepository repo;

    @Autowired
    public ContactService(@Qualifier("contact") ContactRepository repo) {
        this.repo = repo;
    }

    public void addContact(Contact contact) {
        this.repo.save(contact);
    }

    public Iterable<Contact> getAllContacts() {
        return this.repo.findAll();
    }

    public Optional<Contact> getContactById(Long id) {
        return this.repo.findById(id);
    }

    public void deleteContactById(Long id) {
        this.repo.deleteById(id);
    }

    public void updateContactById(Long id, Contact updated) {
        Optional<Contact> optionalContact = this.repo.findById(id);
        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            contact.setFullName(updated.getFullName());
            contact.setJob(updated.getJob());
            this.repo.save(contact);
        }
    }
}
