package com.tidyjava.petclinic.application;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class VisitForm {
    private String owner;
    private String pet;
    private DayOfWeek day;
    private LocalTime time;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
