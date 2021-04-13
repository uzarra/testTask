package com.example.testtask.model;

import javax.persistence.*;

@Entity
@Table(name = "contact_items")
public class ContactItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contact_id")
    private Long contactId;

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Contact contact;

    @Column(name = "contact_item_type")
    private String contactItemType;
    private String value;

    protected ContactItem() {

    }

    public ContactItem(Long contactId, String contactItemType, String value) {
        this.contactId = contactId;
        this.contactItemType = contactItemType;
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

    public String getContactItemType() {
        return contactItemType;
    }

    public void setContactItemType(String contactTypeItem) {
        this.contactItemType = contactTypeItem;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
