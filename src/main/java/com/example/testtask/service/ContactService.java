package com.example.testtask.service;

import com.example.testtask.model.Contact;
import com.example.testtask.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository repo;

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
        if (this.repo.findById(id).isPresent()) {
            this.repo.deleteById(id);
        }
    }

    public void updateContactById(Long id, Contact updated) {
        var optionalContact = this.repo.findById(id);
        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            contact.setFullName(updated.getFullName());
            contact.setJob(updated.getJob());
            this.repo.save(contact);
        }
    }
}
