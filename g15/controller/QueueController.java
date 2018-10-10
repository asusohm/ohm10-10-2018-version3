package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.sa.g15.entity.Queue;
import sut.sa.g15.repository.QueueRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QueueController {
    @Autowired
    private QueueRepository queueRepository;

    @GetMapping(path = "/queue", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Queue> getQueues(){
        return queueRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/queue/{queueQ}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Queue getOneQueue (@PathVariable Long queueQ){
        return queueRepository.findById(queueQ).get();
    }

    @PostMapping(path ="/queue", produces = MediaType.APPLICATION_JSON_VALUE)
    Queue queue(@RequestBody Queue queue){
        return queueRepository.save(queue);
    }

}
