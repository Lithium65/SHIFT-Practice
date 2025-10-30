package org.example.service;


import java.time.ZoneId;
import java.util.Scanner;

public final class TimeZoneInitializer {

    private TimeZoneInitializer() {
    }

    public static ZoneId initializeTimeZone() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the time zone (e.g., Europe/Minsk): ");
        String input = scanner.nextLine();

        try {
            return ZoneId.of(input);
        } catch (Exception e) {
            System.out.println("Invalid timezone. Use UTC.");
            return ZoneId.of("UTC");
        }
    }
}
