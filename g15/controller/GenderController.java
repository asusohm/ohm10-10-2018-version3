package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.sa.g15.entity.Gender;
import sut.sa.g15.repository.GenderRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GenderController {

    @Autowired
    private GenderRepository genderRepository;

    @GetMapping(path = "/gender")
    public Collection<Gender> getGender(){
         return genderRepository.findAll().stream().collect(Collectors.toList());
    }
}
