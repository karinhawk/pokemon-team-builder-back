package com.example.pokemon;

public class TrainerNotFoundException extends RuntimeException {

    public TrainerNotFoundException() {
        super("Trainer does not exist");
    }
}
