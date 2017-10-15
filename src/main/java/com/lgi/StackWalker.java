package com.lgi;

import java.util.stream.Stream;

import static com.lgi.Util.println;

public class StackWalker {
    public static void main(String[] args) {
        one();
    }

    private static void one() {
        two();
    }

    private static void two() {
        three();
    }

    private static void three() {
        String line = java.lang.StackWalker.getInstance().walk(StackWalker::walk);
        java.lang.StackWalker.getInstance().forEach(Util::println);
        println(line);
    }

    private static String walk(Stream<java.lang.StackWalker.StackFrame> stackFrameStream) {
        return stackFrameStream
                .filter(frame -> frame.getMethodName().contains("one"))
                .findFirst()
                .map(frame -> "Line " + frame.getLineNumber())
                .orElse("Unknown line");
    }
}
