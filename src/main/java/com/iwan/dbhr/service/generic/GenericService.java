package com.iwan.dbhr.service.generic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iwan.dbhr.model.generic.BaseEntity;
import com.iwan.dbhr.repository.generic.GenericRepository;

public class GenericService<T extends BaseEntity> {
    @Autowired
    private GenericRepository<T> genericRepository;

    public Optional<T> getById(Long id) throws Exception {
        try {
            return genericRepository.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<T> findAll() throws Exception {
        try {
            return genericRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    public T create(T entity) throws Exception {
        try {
            return genericRepository.save(entity);
        } catch (Exception e) {
            throw e;
        }
    }

    public T update(Long id, T entity) throws Exception {
        try {
            entity.setId(id);
            return genericRepository.save(entity);
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(Long id) throws Exception {
        try {
            genericRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
