package com.robinsonduffy.aliendna.service;

import com.robinsonduffy.aliendna.model.HasId;
import org.springframework.data.repository.CrudRepository;

public class AbstractDataService<T extends HasId> {
    public CrudRepository<T, Long> repository;

    public T getById(final Long id) {
        return repository.findOne(id);
    }

    public Iterable<T> getAll() {
        return repository.findAll();
    }

    public T create(final T entity) {
        return repository.save(entity);
    }

    public T update(Long id, final T entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
