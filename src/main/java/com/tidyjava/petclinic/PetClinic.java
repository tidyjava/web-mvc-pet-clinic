package com.tidyjava.petclinic;

import com.tidyjava.petclinic.application.VisitCalendar;
import com.tidyjava.petclinic.application.VisitCalendarController;
import com.tidyjava.petclinic.domain.time.Week;
import com.tidyjava.petclinic.domain.visits.Visits;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

import static java.time.DayOfWeek.MONDAY;

@SpringBootApplication
public class PetClinic {

    public static void main(String[] args) {
        SpringApplication.run(PetClinic.class, args);
    }
}
