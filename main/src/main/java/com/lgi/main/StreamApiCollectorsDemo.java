package com.lgi.main;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static com.lgi.commons.util.PrintUtil.println;

public class StreamApiCollectorsDemo {
    public static void main(String[] args) {
        // filtering grouping collector
        List<Integer> numbers = List.of(1, 2, 3, 5, 5);

        Map<Integer, Long> result = numbers.stream()
                .filter(val -> val > 3)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        checkArgument(Integer.valueOf(1).equals(result.size()));
        println(result);

        result = numbers.stream()
                .collect(Collectors.groupingBy(i -> i,
                        Collectors.filtering(val -> val > 3, Collectors.counting())));

        checkArgument(Integer.valueOf(4).equals(result.size()));
        println(result);
    }
}
