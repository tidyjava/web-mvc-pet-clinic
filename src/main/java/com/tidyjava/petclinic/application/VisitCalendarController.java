package com.tidyjava.petclinic.application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VisitCalendarController {
    private VisitCalendar visitCalendar;

    public VisitCalendarController(VisitCalendar visitCalendar) {
        this.visitCalendar = visitCalendar;
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("visitCalendar", visitCalendar);
        return "visitCalendar";
    }

    @GetMapping("/next")
    public String nextWeek() {
        visitCalendar.nextWeek();
        return "redirect:/";
    }

    @GetMapping("/previous")
    public String previousWeek() {
        visitCalendar.previousWeek();
        return "redirect:/";
    }

    @PostMapping
    public String addVisit(@ModelAttribute VisitForm visitForm) {
        visitCalendar.addVisit(
                visitForm.getDay(),
                visitForm.getTime(),
                visitForm.getOwner(),
                visitForm.getPet());
        return "redirect:/";
    }
}
