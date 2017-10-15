package com.lgi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.Map.entry;

public class Collection {
    public static void main(String[] args) {
        checkOutLists();
        checkOutMaps();
    }

    private static void checkOutMaps() {
//        Map<String, Integer> turtlesMap = Map.of(
//                "Leonardo", 0,
//                "Donatello", 1,
//                "Raphael", 2,
//                "Michelangelo", 3,
//                "Unknown hero", 4,
//                "Unknown hero", 5,
//                "Unknown hero", 6,
//                "Unknown hero", 7,
//                "Unknown hero", 8,
//                "Unknown hero", 9,
//                "Unknown hero", 10
//        );
        Map<String, Integer> correctTurtles= Map.ofEntries(
                entry("Leonardo", 0),
                entry("Donatello", 1),
                entry("Raphael", 2),
                entry("Michelangelo", 3),
                entry("Unknown hero 1", 4),
                entry("Unknown hero 2", 5),
                entry("Unknown hero 3", 6),
                entry("Unknown hero 4", 7),
                entry("Unknown hero 5", 8),
                entry("Unknown hero 6", 9),
                entry("Unknown hero 7", 10),
                entry("Unknown hero 8", 11),
                entry("Unknown hero 9", 12)
        );
        System.out.println(correctTurtles);
    }

    private static void checkOutLists() {
        List<String> ninjaTurtles = List.of(
                "Leonardo",
                "Donatello",
                "Raphael",
                "Michelangelo");

        try {
            ninjaTurtles.add("New suspicious turtle");
        } catch (UnsupportedOperationException e) {
            System.out.println("I don't remember that guy");
        }

        try {
            ninjaTurtles.set(Objects.checkIndex(3, ninjaTurtles.size()), "New suspicious turtle");
        } catch (UnsupportedOperationException e) {
            System.out.println("I can't replace hero");
        }

        System.out.println("Ninja turtles: " + ninjaTurtles);

        // ---------------------------------------------------------------

        List<String> fakeTurtles = Arrays.asList(
                "Turtle 1",
                "Turtle 2",
                "Turtle 3",
                "Turtle 4",
                null
        );
//        fakeTurtles.add("New suspicious turtle"); --> remove and add not supported because list has fixed size
        fakeTurtles.set(4, "New suspicious turtle");
        System.out.println("Fake turtles: " + fakeTurtles);
    }
}
