package com.example.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    public List<Trainer> getTrainer() {
        return trainerRepository.findAll();
    }

    public void updateTrainer(Trainer updatedTrainer, long id) {
        updatedTrainer.setId(id);
        trainerRepository.save(updatedTrainer);
    }

    public Trainer getTrainerById(long id) {
        Optional<Trainer> trainer = trainerRepository.findById(id);
        return trainer.get();
    }

    @Transactional
    public void deleteTrainerById(long id) {
        if (!trainerRepository.existsById(id)) {
            throw new TrainerNotFoundException();
        }

        trainerRepository.deleteTrainerById(id);
    }

    public void addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }
}
