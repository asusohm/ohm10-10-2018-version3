package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sut.sa.g15.entity.Country;
import sut.sa.g15.repository.CountryRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping(path = "/countrys", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Country> getCountry() {
        return countryRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/country/{countryCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Country getOneCountry(@PathVariable String countryCode) {
        return countryRepository.findById(countryCode).get();
    }
}
