package com.example.testtask.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contact_items")
public class ContactItem {
    @Id
    @Column
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

    @Column
    @Getter @Setter
    private String value;
}
