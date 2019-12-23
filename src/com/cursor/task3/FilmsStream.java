package com.cursor.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilmsStream {
    private static List<Film> buildAfternoonFilmList() {
        List<Film> afternoonFilms = new ArrayList<>();
        afternoonFilms.add(new Film(Genre.DRAMA, 50.00));
        afternoonFilms.add(new Film(Genre.COMEDY, 40.00));
        afternoonFilms.add(new Film(Genre.ACTION, 100.00));
        afternoonFilms.add(new Film(Genre.DRAMA, 70.00));
        afternoonFilms.add(new Film(Genre.COMEDY, 40.00));
        return afternoonFilms;
    }

    private static List<Film> buildEveningFilmList() {
        List<Film> eveningFilms = new ArrayList<>();
        eveningFilms.add(new Film(Genre.COMEDY, 150.00));
        eveningFilms.add(new Film(Genre.ACTION, 300.00));
        eveningFilms.add(new Film(Genre.ACTION, 200.00));
        eveningFilms.add(new Film(Genre.THRILLER, 200.00));
        eveningFilms.add(new Film(Genre.COMEDY, 150.00));
        return eveningFilms;
    }

    public static void processFilms() {
        List<Film> afternoonFilms = buildAfternoonFilmList();
        List<Film> eveningFilms = buildEveningFilmList();
        afternoonFilms.addAll(eveningFilms);

        Map<Genre, Double> genreDoubleMap = afternoonFilms.stream()
                .collect(Collectors.groupingBy(Film::getGenre, Collectors.averagingDouble(Film::getTicketPrice)));
        System.out.println("Average ticket price per genre: " + genreDoubleMap);

        Map<Genre, Long> genreCountMap = afternoonFilms.stream()
                .collect(Collectors.groupingBy(Film::getGenre, Collectors.counting()));
        System.out.println("Number of films per genre: " + genreCountMap);
    }
}