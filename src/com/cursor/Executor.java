package com.cursor;

import com.cursor.task1.PosePrinter;

import static com.cursor.task2.UsersStream.processUsers;
import static com.cursor.task3.FilmsStream.processFilms;

public class Executor {
    public static void start() {
        buildCustomInterface();
        processFilms();
        processUsers();
    }

    public static void buildCustomInterface() {
        PosePrinter posePrinter = name -> System.out.println("Your asana is " + name);
        posePrinter.printPose("Uttanasana");
    }
}
