package com.example.testtask.repository;

import com.example.testtask.model.Contact;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository("contactRepository")
@Transactional
public class ContactRepositoryImpl implements ContactRepository{
    private EntityManager em;

    @Override
    public Long insertContact(Contact contact) {
        return null;
    }

    @Override
    public List<Contact> getAllContacts() {
        return null;
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return Optional.empty();
    }

    @Override
    public int deleteContactById(Long id) {
        return 0;
    }

    @Override
    public int updateContactById(Long id, Contact contact) {
        return 0;
    }
}
