package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.sa.g15.entity.Balance;
import sut.sa.g15.repository.BalanceRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BalanceController {
    @Autowired
    private BalanceRepository balanceRepository;

    @GetMapping("/balance")
    public Collection<Balance> getBalance() {
        return balanceRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/balance/{balanceone}")
    public Balance getBalanceById(@PathVariable Long balanceone) {
        return balanceRepository.findById(balanceone).get();
    }

    @PostMapping("/balance")
    public Balance postBalance(@RequestBody  Balance newBalance){
        return balanceRepository.save(newBalance);
    }

    @PutMapping(path = "/balance/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Balance replaceBalance(@RequestBody Balance newBalance, @PathVariable Long id, Double newBalanceAmount) {
        return balanceRepository.findById(id).map(balance -> {
            balance.setBalanceAmount(newBalanceAmount);
            return balanceRepository.save(balance);
        }).orElseGet(() -> {
            newBalance.setBalanceID(id);
            return balanceRepository.save(newBalance);
        });
    }
}
