package com.lgi.legacy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Java8OnlySource {
    public static void main(String[] args) {
        System.out.println(Arrays.stream(Thread.currentThread()
                .getStackTrace())
                .map(StackTraceElement::toString)
                .collect(Collectors.joining("\n")));
    }
}
