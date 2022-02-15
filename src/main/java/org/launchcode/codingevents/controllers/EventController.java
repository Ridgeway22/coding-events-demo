package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    //private static List<String> events = new ArrayList<>();
    private static HashMap<String,String> events = new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", events);
        events.put("VegFest  ", "Vegan food day");
        events.put("Groove Fest  ", "Live Music");
        events.put("Taste of Soulard  ", "Food from restaurants and pubs.");

        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");

        return "events/create";
    }



    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription, Model model) {
        model.addAttribute("eventName", eventName);
        model.addAttribute("eventDescription", eventDescription);
        events.put(eventName, eventDescription);
        return "redirect:/events";
    }

}
