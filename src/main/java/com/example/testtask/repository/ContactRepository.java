package com.example.testtask.repository;

import com.example.testtask.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("contact")
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
