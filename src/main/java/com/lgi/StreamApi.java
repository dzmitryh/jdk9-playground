package com.lgi;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamApi {
    private static final List<String> allHeroes =
            List.of("Leonardo", "Donatello", "Raphael", "Michelangelo", "Shredder", "Bebop");

    private static final List<String> badGuys =
            List.of("Shredder", "Bebop");

    private static final Predicate<? super String> isNotABadGuy = hero -> !badGuys.contains(hero);

    public static void main(String[] args) {
        // takeWhile && dropWhile

        List<String> onlyGoodGuys = allHeroes.stream().takeWhile(isNotABadGuy).collect(toList());
        System.out.println(onlyGoodGuys);

        List<String> onlyBadGuys = allHeroes.stream().dropWhile(isNotABadGuy).collect(toList());
        System.out.println(onlyBadGuys);

        // ofNullable

        // Java 8
        Turtle turtle = getTurtle("Leonardo");
        Stream<Weapon> weapons = turtle == null ? Stream.empty(): turtle.weapons();

        // Java 9
        weapons = Stream.ofNullable(turtle).flatMap(Turtle::weapons);
        System.out.println(weapons.collect(toList()));
    }

    // -----------------------------------------------------------------------------

    private static Turtle getTurtle(String name) {
        return new Turtle(name);
    }

    private static class Turtle {
        final String name;

        private Turtle(String name) {
            this.name = name;
        }

        Stream<Weapon> weapons() {
            return Stream.of(
                    new Weapon("katana", 40),
                    new Weapon("sai", 20),
                    new Weapon("nunchaku", 30));
        }
    }

    private static class Weapon {
        final String name;
        final int damage;

        Weapon(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        @Override
        public String toString() {
            return "Weapon{" +
                    "name='" + name + '\'' +
                    ", damage=" + damage +
                    '}';
        }
    }
}