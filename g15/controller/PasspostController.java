package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g15.entity.Passport;
import sut.sa.g15.repository.PassportRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PasspostController {
@Autowired
private PassportRepository passportRepository;
@PostMapping (path = "/passport")
    public Passport postPassport(@RequestBody Passport passport){
    return passportRepository.save(passport);
}
@GetMapping(path = "/passport/{passNum}")
    public Passport passport(@PathVariable Long passNum){
    return passportRepository.findById(passNum).get();
}
}
