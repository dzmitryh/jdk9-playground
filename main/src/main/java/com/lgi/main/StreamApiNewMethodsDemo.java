package com.lgi.main;

import com.lgi.commons.model.Turtle;
import com.lgi.commons.model.Weapon;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamApiNewMethodsDemo {
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
//        Turtle turtle = null;
//        Stream<Weapon> weapons = turtle == null ? Stream.empty(): turtle.weapons();

        // Java 9
        Stream<Weapon> weapons = Stream.ofNullable(turtle).flatMap(Turtle::weapons);
        System.out.println((turtle != null ? turtle.getName() : "Unknown hero") + " has the following weapons: " + weapons.collect(toList()));
    }

    // -----------------------------------------------------------------------------

    private static Turtle getTurtle(String name) {
        return new Turtle(name);
    }
}
