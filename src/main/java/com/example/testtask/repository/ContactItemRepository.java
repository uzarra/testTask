package com.example.testtask.repository;

import com.example.testtask.model.ContactItem;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactItemRepository extends CrudRepository<ContactItem, Long>, JpaSpecificationExecutor<ContactItem> {
}
