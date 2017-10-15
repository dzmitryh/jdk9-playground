package com.lgi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Stream;

import static com.lgi.Util.println;
import static java.util.stream.Collectors.toList;

public class DatesDemo {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusWeeks(1);

        println(getDatesBetweenUsingJava8(startDate, endDate));
        println(getDatesBetweenUsingJava9(startDate, endDate));
    }

    private static List<LocalDate> getDatesBetweenUsingJava8(LocalDate startDate, LocalDate endDate) {
        return Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(startDate, endDate))
                .collect(toList());
    }

    private static List<LocalDate> getDatesBetweenUsingJava9(LocalDate startDate, LocalDate endDate) {
        return startDate.datesUntil(endDate).collect(toList());
    }
}
