package com.example.moviebooking.service;

import com.example.moviebooking.model.Movie;
import com.example.moviebooking.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {

    private Set<String> movies = new HashSet<>();
    private List<Ticket> bookedTickets = new ArrayList<>();
    private Queue<Ticket> waitingList = new LinkedList<>();

    private final int MAX_SEATS = 5;

    public String addMovie(String name) {
        movies.add(name);
        return "Movie added";
    }

    public Set<String> getMovies() {
        return movies;
    }

    public String bookTicket(String customer, String movie) {
        if (!movies.contains(movie)) {
            return "Movie not found";
        }

        if (bookedTickets.size() < MAX_SEATS) {
            bookedTickets.add(new Ticket(customer, movie));
            return "Ticket booked";
        } else {
            waitingList.add(new Ticket(customer, movie));
            return "Added to waiting list";
        }
    }

    public List<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    public Queue<Ticket> getWaitingList() {
        return waitingList;
    }

    public String processNext() {
        if (waitingList.isEmpty()) return "No waiting";

        if (bookedTickets.size() < MAX_SEATS) {
            Ticket t = waitingList.poll();
            bookedTickets.add(t);
            return "Seat given to " + t.getCustomerName();
        }

        return "No seats available";
    }
}