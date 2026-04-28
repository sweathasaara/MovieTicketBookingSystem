package com.example.moviebooking.controller;

import com.example.moviebooking.model.Ticket;
import com.example.moviebooking.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Queue;
import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final BookingService service;

    public MovieController(BookingService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public String addMovie(@RequestParam String name) {
        return service.addMovie(name);
    }

    @GetMapping
    public Set<String> getMovies() {
        return service.getMovies();
    }

    @PostMapping("/book")
    public String book(@RequestParam String customer,
                       @RequestParam String movie) {
        return service.bookTicket(customer, movie);
    }

    @GetMapping("/tickets")
    public List<Ticket> tickets() {
        return service.getBookedTickets();
    }

    @GetMapping("/waiting")
    public Queue<Ticket> waiting() {
        return service.getWaitingList();
    }

    @PostMapping("/process")
    public String process() {
        return service.processNext();
    }
}