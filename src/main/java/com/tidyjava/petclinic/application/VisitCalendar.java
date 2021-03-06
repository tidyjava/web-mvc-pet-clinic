package com.tidyjava.petclinic.application;

import com.tidyjava.petclinic.domain.time.Week;
import com.tidyjava.petclinic.domain.visits.Owner;
import com.tidyjava.petclinic.domain.visits.Pet;
import com.tidyjava.petclinic.domain.visits.Visit;
import com.tidyjava.petclinic.domain.visits.Visits;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.DayOfWeek.*;
import static java.util.Arrays.asList;

@Service
@SessionScope
public class VisitCalendar {
    private static final List<DayOfWeek> OPEN_DAYS = asList(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY);
    private static final LocalTime OPEN_TIME = LocalTime.of(8, 0);
    private static final LocalTime CLOSE_TIME = LocalTime.of(18, 0);
    private static final int VISIT_DURATION = 30;

    private Week currentWeek;
    private Visits visits;

    public VisitCalendar(Visits visits) {
        this.currentWeek = Week.since(LocalDate.now().with(MONDAY));
        this.visits = visits;
    }

    public Week getCurrentWeek() {
        return currentWeek;
    }

    public List<DayOfWeek> getOpenDays() {
        return OPEN_DAYS;
    }

    public List<LocalTime> getVisitTimes() {
        List<LocalTime> visitTimes = new ArrayList<>();
        for (LocalTime time = OPEN_TIME; time.isBefore(CLOSE_TIME); time = time.plusMinutes(VISIT_DURATION)) {
            visitTimes.add(time);
        }
        return visitTimes;
    }

    void nextWeek() {
        this.currentWeek = currentWeek.next();
    }

    void previousWeek() {
        this.currentWeek = currentWeek.previous();
    }

    public Visit visitOn(DayOfWeek day, LocalTime time) {
        return visits.on(currentWeek.get(day).atTime(time)).orElse(null);
    }

    void addVisit(DayOfWeek dayOfWeek, LocalTime time, String ownerName, String petName) {
        LocalDateTime dateTime = currentWeek.get(dayOfWeek).atTime(time);
        Owner owner = new Owner(ownerName);
        List<Pet> pets = asList(new Pet(petName, owner));
        visits.add(new Visit(dateTime, pets));
    }
}
