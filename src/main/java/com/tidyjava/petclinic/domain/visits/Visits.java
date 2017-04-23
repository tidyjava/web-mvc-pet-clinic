package com.tidyjava.petclinic.domain.visits;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.Month.APRIL;

@Repository
public class Visits {
    private List<Visit> visits = new ArrayList<>();

    public void add(Visit visit) {
        this.visits.add(visit);
    }

    public Optional<Visit> on(LocalDateTime dateTime) {
        return visits.stream()
                .filter(visit -> visit.isOn(dateTime))
                .findFirst();
    }
}
