package com.lgi.main;

import com.lgi.commons.util.PrintUtil;

import java.util.stream.Stream;

import static com.lgi.commons.util.PrintUtil.println;

public class StackWalkerDemo {
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
        String line = StackWalker.getInstance().walk(StackWalkerDemo::walk);
        StackWalker.getInstance().forEach(PrintUtil::println);
        println(line);
    }

    private static String walk(Stream<StackWalker.StackFrame> stackFrameStream) {
        return stackFrameStream
                .filter(frame -> frame.getMethodName().contains("one"))
                .findFirst()
                .map(frame -> "Line " + frame.getLineNumber())
                .orElse("Unknown line");
    }
}
