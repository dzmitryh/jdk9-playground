package com.lgi.commons.model;

import java.util.stream.Stream;

public class Turtle {
    private final String name;

    public Turtle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Stream<Weapon> weapons() {
        return Stream.of(
                new Weapon("katana", 40),
                new Weapon("sai", 20),
                new Weapon("nunchaku", 30));
    }
}
