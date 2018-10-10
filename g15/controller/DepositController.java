package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.sa.g15.entity.Deposit;
import sut.sa.g15.repository.DepositRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DepositController {
    @Autowired
    private DepositRepository depositRepository;

    @PostMapping(path = "/deposit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Deposit newDeposit(@RequestBody Deposit deposit) {
        return depositRepository.save(deposit);
    }

    @GetMapping("/deposit")
    public Collection<Deposit> getDeposit() {
        return depositRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/deposit/{depositone}")
    public Deposit getOneDeposit(@PathVariable Long depositone) {
        return depositRepository.findById(depositone).get();
    }

    @GetMapping("/deposit/amount/{amount}")
    public Deposit getDepositByAmount(@PathVariable Double amount) {
        if (depositRepository.findByDepositAmount(amount) == null)
            System.out.println("Nulll");
        return depositRepository.findByDepositAmount(amount);
    }

}
