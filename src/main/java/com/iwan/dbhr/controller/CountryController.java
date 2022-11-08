package com.iwan.dbhr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iwan.dbhr.controller.generic.GenericController;
import com.iwan.dbhr.model.Country;
import com.iwan.dbhr.model.dto.response.CountryRegion;
import com.iwan.dbhr.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController extends GenericController<Country> {

    @Autowired
    private CountryService cService;

    @GetMapping("/countryregions")
    public ResponseEntity<List<CountryRegion>> getCountryRegions() throws Exception {
        return new ResponseEntity<List<CountryRegion>>(cService.getCountryRegion(), HttpStatus.OK);
    }
}
