package com.example.testtask.service;

import com.example.testtask.model.ContactItem;
import com.example.testtask.model.ContactItemSpecifications;
import com.example.testtask.repository.ContactItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactItemService {
    private final ContactItemRepository repo;

    public void addContactItem(ContactItem contactItem) {
        repo.save(contactItem);
    }

    public Iterable<ContactItem> getAllContactItemsFilteredByContactId(Long contactId) {
        return repo.findAll(ContactItemSpecifications.filterByContact(contactId));
    }

    public Iterable<ContactItem> getAllContactItems() {
        return repo.findAll();
    }

    public Optional<ContactItem> getContactItemById(Long id) {
        return repo.findById(id);
    }

    public void deleteContactItemById(Long id) {
        repo.deleteById(id);
    }

    public void updateContactItemById(Long id, ContactItem updated) {
        var optionalContactItem = repo.findById(id);
        if (optionalContactItem.isPresent()) {
            ContactItem contactItem = optionalContactItem.get();
            contactItem.setContactItemType(updated.getContactItemType());
            contactItem.setValue(updated.getValue());
            repo.save(contactItem);
        }
    }
}
