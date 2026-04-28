package com.example.moviebooking.model;

public class Ticket {
    private String customerName;
    private String movieName;

    public Ticket(String customerName, String movieName) {
        this.customerName = customerName;
        this.movieName = movieName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMovieName() {
        return movieName;
    }
}