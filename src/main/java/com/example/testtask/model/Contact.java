package com.example.testtask.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.util.Assert.notNull;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(name = "fullname")
    @NotNull
    @Getter @Setter
    private String fullName;

    @Getter @Setter
    private String job;

    @OneToMany(mappedBy = "contact")
    private List<ContactItem> contactItems;

    public Contact() {

    }

    public Contact(String fullName, String job) {
        notNull(fullName, "null fullName");
        this.fullName = fullName;
        this.job = job;
    }
}
