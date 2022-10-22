package com.example.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(TrainerNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @PostMapping("/trainer")
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer) {
        trainerService.addTrainer(trainer);
        return ResponseEntity.status(HttpStatus.CREATED).body(trainer);
    }

    @GetMapping("/trainer")
    public ResponseEntity<List<Trainer>> getTrainer() {
        return ResponseEntity.status(HttpStatus.OK).body(trainerService.getTrainer());
    }

    @PutMapping("/trainer/{id}")
    public ResponseEntity<Trainer> updateTrainer(@RequestBody Trainer updatedTrainer, @PathVariable long id) {
        trainerService.getTrainerById(id);
        trainerService.updateTrainer(updatedTrainer, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedTrainer);
    }

    @DeleteMapping("/trainer/{id}")
    @Transactional
    public ResponseEntity<String> deleteTrainerById(@PathVariable long id) {
        trainerService.deleteTrainerById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
