package com.example.testtask.api;

import com.example.testtask.model.Contact;
import com.example.testtask.service.ContactService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/contacts")
@RestController
public class ContactController {
    private final ContactService service;

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

    @PostMapping
    public void addContact(@Validated @NotNull @RequestBody Contact contact) {
        this.service.addContact(contact);
    }

    @GetMapping
    public Iterable<Contact> getAllContacts() {
        return this.service.getAllContacts();
    }

    @GetMapping(path = "{id}")
    public Contact getContactById(@PathVariable("id") Long id) {
        return this.service.getContactById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteContactById(@PathVariable("id") Long id) {
        this.service.deleteContactById(id);
    }

    @PutMapping(path = "{id}")
    public void updateContact(@PathVariable("id") Long id, @RequestBody Contact contact) {
        this.service.updateContactById(id, contact);
    }
}
