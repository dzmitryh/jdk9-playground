package com.lgi.main;

import java.util.stream.IntStream;

import static com.lgi.commons.util.PrintUtil.println;

public class PrivateMethodInInterface {
    public static void main(String[] args) {
        new SumTest(new int[]{1,2,3,4}).calculate();
    }
}

interface Sum {
    default boolean evenSum(int[] numbers) {
        return sum(numbers) % 2 == 0;
    }

    default boolean oddSum(int[] numbers) {
        return sum(numbers) % 2 == 1;
    }

    // we don't want this to be public;
    private int sum(int[] numbers) {
        return IntStream.of(numbers).sum();
    }
}

class SumTest implements Sum {
    private final int[] numbers;

    SumTest(int[] numbers) {
        this.numbers = numbers;
    }

    void calculate() {
        println("Is sum even ? -> " + this.evenSum(numbers));
        println("Is sum odd ? -> " + this.oddSum(numbers));
        // has a private access
//        println(this.sum(1, 2, 3, 4));
    }
}
