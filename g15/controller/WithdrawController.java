package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.sa.g15.entity.Withdraw;
import sut.sa.g15.repository.WithdrawRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WithdrawController {
    @Autowired
    private WithdrawRepository withdrawRepository;

    @PostMapping(path = "/withdraw", produces = MediaType.APPLICATION_JSON_VALUE)
    public Withdraw newWithdraw(@RequestBody Withdraw withdraw) {
        return withdrawRepository.save(withdraw);
    }

    @GetMapping("/withdraw")
    public Collection<Withdraw> getWithdraw() {
        return withdrawRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/withdraw/{withdrawone}")
    public Withdraw getOneWithdraw(@PathVariable Long withdrawone) {
        return withdrawRepository.findById(withdrawone).get();

    }

    public Withdraw getWithDrawByAmount(Double amount) {
        return withdrawRepository.findByWithdrawAmount(amount);
    }
}
