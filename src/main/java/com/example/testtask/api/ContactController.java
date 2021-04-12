package com.example.testtask.api;

import com.example.testtask.model.Contact;
import com.example.testtask.service.ContactService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/contacts")
@RestController
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public void addContact(@Validated @NotNull @RequestBody Contact contact) {
        this.contactService.addContact(contact);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return this.contactService.getAllContacts();
    }

    @GetMapping(path = "{id}")
    public Contact getContactById(@PathVariable("id") Long id) {
        return this.contactService.getContactById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteContactById(@PathVariable("id") Long id) {
        this.contactService.deleteContactById(id);
    }

    @PutMapping(path = "{id}")
    public void updateContact(@PathVariable("id") Long id, @RequestBody Contact contact) {
        this.contactService.updateContactById(id, contact);
    }
}
