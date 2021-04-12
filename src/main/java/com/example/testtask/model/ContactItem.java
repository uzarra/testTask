package com.example.testtask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long contactId;
    private String contactTypeItem;
    private String value;

    protected ContactItem() {

    }

    public ContactItem(Long contactId, String contactTypeItem, String value) {
        this.contactId = contactId;
        this.contactTypeItem = contactTypeItem;
        this.value = value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getContactTypeItem() {
        return contactTypeItem;
    }

    public void setContactTypeItem(String contactTypeItem) {
        this.contactTypeItem = contactTypeItem;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
