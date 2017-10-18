package com.lgi.main;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.lgi.commons.util.PrintUtil.println;

public class OptionalDemo {
    public static void main(String[] args) {
        demoOptionalOr();
        demoOptionalIfPresentOrElse();
        demoOptionalStream();
    }

    private static void demoOptionalOr() {
        String expectedHero = "Leonardo";
        Optional<String> value = Optional.of(expectedHero);
//        Optional<String> value = Optional.empty();
        Optional<String> defaultHero = Optional.of("Default hero");
        Optional<String> result = value.or(() -> defaultHero);
        println(result.get());
    }

    private static void demoOptionalIfPresentOrElse() {
        Optional<String> hero = Optional.of("Raphael");
//        Optional<String> hero = Optional.empty();
        AtomicInteger successCounter = new AtomicInteger(0);
        AtomicInteger onEmptyOptionalCounter = new AtomicInteger(0);

        hero.ifPresentOrElse(
                v -> successCounter.incrementAndGet(),
                onEmptyOptionalCounter::incrementAndGet);

        println(successCounter.get());
        println(onEmptyOptionalCounter.get());
    }

    private static void demoOptionalStream() {
        Optional<String> hero = Optional.of("Donatello");
//        Optional<String> hero = Optional.empty();
        List<String> heroes = hero.stream().map(String::toUpperCase).collect(Collectors.toList());
        println(heroes);
    }
}
