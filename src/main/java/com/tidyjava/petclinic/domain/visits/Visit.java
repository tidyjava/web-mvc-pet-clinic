package com.tidyjava.petclinic.domain.visits;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class Visit {
    private LocalDateTime dateTime;
    private List<Pet> pets;

    public Visit(LocalDateTime dateTime, List<Pet> pets) {
        this.dateTime = dateTime;
        this.pets = pets;
    }

    public String getOwnerName() {
        return pets.get(0).getOwnerName();
    }

    public List<String> getPetNames() {
        return pets.stream()
                .map(Pet::getName)
                .collect(Collectors.toList());
    }

    public boolean isOn(LocalDateTime dateTime) {
        return this.dateTime.equals(dateTime);
    }
}
