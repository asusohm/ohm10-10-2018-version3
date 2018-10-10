package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sut.sa.g15.entity.Position;
import sut.sa.g15.repository.PositionRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PositionController {
    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/position")
    public Collection<Position> getPosition() {
        return positionRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/position/{positionone}")
    public Position getOnePosition(@PathVariable Long positionone) {
        return positionRepository.findById(positionone).get();
    }

}
