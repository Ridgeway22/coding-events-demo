package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
   // private static HashMap<String,String> events = new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        EventData.add(new Event("VegFest", "Vegan food day"));
        EventData.add(new Event("Groove Fest  ", "Live Music"));
        EventData.add(new Event("Taste of Soulard  ", "Food from restaurants and pubs."));

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
        EventData.add(new Event(eventName, eventDescription));
        return "redirect:/events";
    }

    @GetMapping("edit/${eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        // controller code will go here
        EventData.getById(eventId);
        model.addAttribute("title", "Edit Event NAME (id=ID)");
        model.addAttribute("eventId", eventId);
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description, Model model) {
        // controller code will go here
        model.addAttribute("eventID", eventId);
        model.addAttribute("name", name);

        EventData.getById(eventId);
        return "redirect:/events";
    }

    @GetMapping("delete")
    public String dislplayDeleteEvent(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEvent(@RequestParam(required = false) int[] eventIds){
        if (eventIds != null){
            for (int id : eventIds){
                EventData.remove(id);
            }}
        return "redirect: ";
    }

}
