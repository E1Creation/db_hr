package com.iwan.dbhr.repository;

import org.springframework.stereotype.Repository;

import com.iwan.dbhr.model.Country;
import com.iwan.dbhr.repository.generic.GenericRepository;

@Repository
public interface CountryRepository extends GenericRepository<Country> {

}
