package com.example.testtask.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Getter @Setter
public class Contact {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    @NotNull
    private String fullName;

    @Column
    private String job;

    @OneToMany(mappedBy = "contact")
    @JsonManagedReference
    private List<ContactItem> contactItems;

    public Contact(String fullName, String job) {
        notNull(fullName, "null fullName");
        this.fullName = fullName;
        this.job = job;
    }
}
