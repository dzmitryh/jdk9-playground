package com.lgi;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.lgi.Util.println;

public class ObjectsDemo {
    public static void main(String[] args) {
        List<String> ninjaTurtles = Arrays.asList(
                "Leonardo",
                "Donatello",
                "Raphael",
                null,
                "Michelangelo");

        Objects.checkIndex(3, ninjaTurtles.size());
        println(Objects.requireNonNullElse(ninjaTurtles.get(3), "Unknown hero"));
        // but still not the Elvis operator.. Let's wait java 10 -> println(ninjaTurtles.get(3) ?: "Unknown hero");
        println(Objects.requireNonNullElseGet(ninjaTurtles.get(3), ObjectsDemo::findHero));
    }

    private static String findHero() {
        return "Splinter";
    }
}
