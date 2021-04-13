package com.example.testtask.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "job")
    private String job;

    @OneToMany(mappedBy = "contact")
    private List<ContactItem> contactItems;

    protected Contact() {

    }

    public Contact(String fullName, String job) {
        this.fullName = fullName;
        this.job = job;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
