package com.udacity.jdnd.course3.critter.entity;

import jakarta.persistence.Entity;

@Entity
public class Dog extends Pet {

    private String breed;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
