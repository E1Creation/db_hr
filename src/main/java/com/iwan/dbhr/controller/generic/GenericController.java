package com.iwan.dbhr.controller.generic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iwan.dbhr.model.generic.BaseEntity;
import com.iwan.dbhr.service.generic.GenericService;

@SuppressWarnings({ "unchecked", "rawtypes" })
@ResponseBody
public class GenericController<T extends BaseEntity> {

    @Autowired
    private GenericService<T> service;

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        try {
            return new ResponseEntity(service.create(entity), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable("id") Long id, @RequestBody T entity) {
        try {
            return new ResponseEntity(service.update(id, entity), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<T>> findAll() throws Exception {
        return new ResponseEntity(service.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity(service.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity("Success!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
