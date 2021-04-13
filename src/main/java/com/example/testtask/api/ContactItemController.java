package com.example.testtask.api;

import com.example.testtask.model.ContactItem;
import com.example.testtask.service.ContactItemService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/contactItems")
@RestController
public class ContactItemController {
    private final ContactItemService service;

    @Autowired
    public ContactItemController(ContactItemService service) {
        this.service = service;
    }

    @PostMapping
    public void addContactItem(@Validated @NotNull @RequestBody ContactItem contactItem) {
        this.service.addContactItem(contactItem);
    }

    @GetMapping
    public Iterable<ContactItem> getAllContacts() {
        return this.service.getAllContactItems();
    }

    @GetMapping(path = "contactId={contactId}")
    public Iterable<ContactItem> getContactItemsByContactId(@NotNull @PathVariable("contactId") Long id) {
        return this.service.getAllContactItemsFilteredByContactId(id);
    }

    @GetMapping(path = "{id}")
    public ContactItem getContactById(@PathVariable("id") Long id) {
        return this.service.getContactItemById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteContactById(@PathVariable("id") Long id) {
        this.service.deleteContactItemById(id);
    }

    @PutMapping(path = "{id}")
    public void updateContact(@PathVariable("id") Long id, @RequestBody ContactItem contact) {
        this.service.updateContactItemById(id, contact);
    }
}
