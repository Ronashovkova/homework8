package com.cursor.task3;

public class Film {

    private Genre genre;
    private double ticketPrice;

    public Film(Genre genre, double ticketPrice) {
        this.genre = genre;
        this.ticketPrice = ticketPrice;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public String toString() {
        return "Film{" +
                "genre=" + genre +
                ", priceOfTicket=" + ticketPrice +
                '}';
    }
}
