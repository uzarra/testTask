package com.example.testtask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.util.Assert.notNull;

@Entity
@Table(name = "contacts")
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(name = "fullname")
    @NotNull
    @Getter @Setter
    private String fullName;

    @Column
    @Getter @Setter
    private String job;

    @OneToMany(mappedBy = "contact")
    private List<ContactItem> contactItems;

    public Contact(String fullName, String job) {
        notNull(fullName, "null fullName");
        this.fullName = fullName;
        this.job = job;
    }
}
