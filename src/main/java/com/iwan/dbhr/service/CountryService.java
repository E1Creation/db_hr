package com.iwan.dbhr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iwan.dbhr.model.Country;
import com.iwan.dbhr.model.dto.response.CountryRegion;
import com.iwan.dbhr.repository.generic.GenericRepository;
import com.iwan.dbhr.service.generic.GenericService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CountryService extends GenericService<Country> {
    GenericRepository<Country> cRepository;

    public List<CountryRegion> getCountryRegion() throws Exception {
        List<Country> countries = cRepository.findAll();
        List<CountryRegion> countryRegions = new ArrayList<>();
        for (Country country : countries) {
            countryRegions.add(new CountryRegion(country.getId(), country.getName(), country.getRegion().getName()));
        }
        return countryRegions;
    }
}
