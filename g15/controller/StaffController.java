package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sut.sa.g15.entity.Staff;
import sut.sa.g15.repository.StaffRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StaffController {
    @Autowired
    private StaffRepository staffRepository;

    @GetMapping(path = "/update-rate-staff", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Staff> getUpdateRateStaff() {
        return staffRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/staff", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Staff> getStaffAll() {
        return staffRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/staff/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Staff getOneUpdateExchangeRateStaff(@PathVariable String id) {
        return staffRepository.findById(id).get();
    }
}
