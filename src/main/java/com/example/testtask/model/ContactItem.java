package com.example.testtask.model;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static org.springframework.util.Assert.notNull;

@Entity
@Table(name = "contact_items")
public class ContactItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(name = "contact_id")
    @NotNull
    @Getter @Setter
    private Long contactId;

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Contact contact;

    @Column(name = "contact_item_type")
    @NotNull
    @Getter @Setter
    private String contactItemType;

    @Getter @Setter
    private String value;

    public ContactItem() {

    }

    public ContactItem(Long contactId, String contactItemType, String value) {
        notNull(contactId, "null contactId");
        notNull(contactItemType, "null contactItemType");
        this.contactId = contactId;
        this.contactItemType = contactItemType;
        this.value = value;
    }
}
