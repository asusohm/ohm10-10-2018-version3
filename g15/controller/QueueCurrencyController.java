package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.sa.g15.entity.QueueCurrency;
import sut.sa.g15.repository.QueueCurrencyRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QueueCurrencyController {
    @Autowired
    private QueueCurrencyRepository queueCurrencyRepository;

    @GetMapping(path = "/queuecurrency", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<QueueCurrency> getQueueCurrencyAll(){
        return queueCurrencyRepository.findAll().stream().collect(Collectors.toList());

    }
    @GetMapping(path = "/queuecurrency/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public QueueCurrency getQueueCurrencyById(@PathVariable Long id){
        return queueCurrencyRepository.findById(id).get();
    }

    @PostMapping(path = "/queuecurrency", produces = MediaType.APPLICATION_JSON_VALUE)
    public QueueCurrency postQueueCurrency(@RequestBody QueueCurrency queueCurrency){
        return queueCurrencyRepository.save(queueCurrency);
    }


}
