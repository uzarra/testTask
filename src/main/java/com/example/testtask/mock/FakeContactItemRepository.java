package com.example.testtask.mock;

import com.example.testtask.model.ContactItem;
import com.example.testtask.repository.ContactItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("fakeContactItem")
public class FakeContactItemRepository implements ContactItemRepository {

    public Optional<ContactItem> findOne(Specification<ContactItem> specification) {
        return Optional.empty();
    }

    public List<ContactItem> findAll(Specification<ContactItem> specification) {
        return null;
    }

    public Page<ContactItem> findAll(Specification<ContactItem> specification, Pageable pageable) {
        return null;
    }

    public List<ContactItem> findAll(Specification<ContactItem> specification, Sort sort) {
        return null;
    }

    public long count(Specification<ContactItem> specification) {
        return 0;
    }

    public <S extends ContactItem> S save(S s) {
        return null;
    }

    public <S extends ContactItem> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    public Optional<ContactItem> findById(Long aLong) {
        return Optional.empty();
    }

    public boolean existsById(Long aLong) {
        return false;
    }

    public Iterable<ContactItem> findAll() {
        return null;
    }

    public Iterable<ContactItem> findAllById(Iterable<Long> iterable) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteById(Long aLong) {

    }

    public void delete(ContactItem contactItem) {

    }

    public void deleteAll(Iterable<? extends ContactItem> iterable) {

    }

    public void deleteAll() {

    }
}
