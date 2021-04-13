package com.example.testtask.service;

import com.example.testtask.model.ContactItem;
import com.example.testtask.model.ContactItemSpecifications;
import com.example.testtask.repository.ContactItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactItemService {
    private final ContactItemRepository repo;

    @Autowired
    public ContactItemService(@Qualifier("contactItem") ContactItemRepository repo) {
        this.repo = repo;
    }

    public void addContactItem(ContactItem contactItem) {
        this.repo.save(contactItem);
    }

    public Iterable<ContactItem> getAllContactItemsFilteredByContactId(Long contactId) {
        return this.repo.findAll(ContactItemSpecifications.filterByContact(contactId));
    }

    public Iterable<ContactItem> getAllContactItems() {
        return this.repo.findAll();
    }

    public Optional<ContactItem> getContactItemById(Long id) {
        return this.repo.findById(id);
    }

    public void deleteContactItemById(Long id) {
        this.repo.deleteById(id);
    }

    public void updateContactItemById(Long id, ContactItem updated) {
        Optional<ContactItem> optionalContactItem = this.repo.findById(id);
        if (optionalContactItem.isPresent()) {
            ContactItem contactItem = optionalContactItem.get();
            contactItem.setContactItemType(updated.getContactItemType());
            contactItem.setValue(updated.getValue());
            this.repo.save(contactItem);
        }
    }
}