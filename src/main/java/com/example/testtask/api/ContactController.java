package com.example.testtask.api;

import com.example.testtask.model.Contact;
import com.example.testtask.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/contacts")
@RestController
@RequiredArgsConstructor
public class ContactController {
    private final ContactService service;

    @PostMapping
    public void addContact(@RequestBody Contact contact) {
        service.addContact(contact);
    }

    @GetMapping
    public Iterable<Contact> getAllContacts() {
        return service.getAllContacts();
    }

    @GetMapping(path = "{id}")
    public Contact getContactById(@PathVariable("id") Long id) {
        return service.getContactById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteContactById(@PathVariable("id") Long id) {
        service.deleteContactById(id);
    }

    @PutMapping(path = "{id}")
    public void updateContact(@PathVariable("id") Long id, @RequestBody Contact contact) {
        service.updateContactById(id, contact);
    }
}
