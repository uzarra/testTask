package com.example.testtask.model;

import org.springframework.data.jpa.domain.Specification;

public class ContactItemSpecifications {
    public static Specification<ContactItem> filterByContact(Long contactId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("contactId"), contactId);
    }
}
