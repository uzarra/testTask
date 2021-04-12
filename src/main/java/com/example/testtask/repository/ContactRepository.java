package com.example.testtask.repository;

import com.example.testtask.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {
    Long insertContact(Contact contact);
    List<Contact> getAllContacts();
    Optional<Contact> getContactById(Long id);
    int deleteContactById(Long id);
    int updateContactById(Long id, Contact contact);
}
