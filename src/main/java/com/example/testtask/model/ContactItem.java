package com.example.testtask.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "contact_items")
public class ContactItem {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contact_id")
    @NotNull
    private Long contactId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "contact_id", nullable = false, insertable = false, updatable = false)
    private Contact contact;

    @Column(name = "contact_item_type")
    @NotNull
    private String contactItemType;

    @Column
    private String value;
}
