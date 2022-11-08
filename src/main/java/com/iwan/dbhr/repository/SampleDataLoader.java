package com.iwan.dbhr.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.iwan.dbhr.model.Country;
import com.iwan.dbhr.model.Location;
import com.iwan.dbhr.model.Region;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final CountryRepository countryRepository;
    private final Faker faker;

    public SampleDataLoader(RegionRepository regionRepository, CountryRepository countryRepository) {
        this.regionRepository = regionRepository;
        this.countryRepository = countryRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        Random random = new Random();

        if (regionRepository.count() == 0) {
            String[] regions = {
                    "Asia",
                    "Eropa",
                    "America",
                    "Africa",
                    "Australia"
            };
            List<Region> newRegions = new ArrayList<>();
            for (String r : regions) {
                newRegions.add(new Region(null, r, null));
            }
            regionRepository.saveAll(newRegions);
        }
        if (countryRepository.count() == 0) {
            List<Country> countries = IntStream.rangeClosed(1, 25).mapToObj(country -> new Country(
                    faker.country().countryCode2(),
                    faker.country().capital(),
                    new Region(Long.valueOf(random.nextInt(5) + 1)),
                    null)).collect(Collectors.toList());
            countryRepository.saveAll(countries);
        }

    }
}
