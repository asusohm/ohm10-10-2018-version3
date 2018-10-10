package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g15.entity.UserProfile;
import sut.sa.g15.repository.UserProfileRepository;

import java.awt.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")


public class UserProfileController {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @PostMapping(path = "/userprofile")
    public UserProfile postUserProfile(@RequestBody UserProfile userProfile){
        return userProfileRepository.save(userProfile);
    }
    @GetMapping(path = "/userprofile/{id}")
    public UserProfile getUserProfile(@PathVariable Long id){
        return userProfileRepository.findById(id).get();
    }


}
