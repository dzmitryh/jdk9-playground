package com.lgi;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import static com.lgi.Util.println;
import static java.util.Arrays.asList;

public class ProcessApiDemo {
    public static void main(String[] args) throws IOException {
        observeProcessInfo();

        spawnNewOne();

        enumerateAllProcesses();

        psAuxGrepJava();
    }

    private static void observeProcessInfo() {
        ProcessHandle ph = ProcessHandle.current();
        println(ph.info());
        println("PID: " + ph.pid());
        println("User: " + ph.info().user().orElse("Unknown"));
        println("CPU time so far: " + ph.info().totalCpuDuration().orElse(Duration.ZERO));
    }

    private static void spawnNewOne() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-version");
        Process process = processBuilder.inheritIO().start();
        ProcessHandle ph = process.toHandle();
        println(ph.info());
    }

    private static void enumerateAllProcesses() {
        Stream<ProcessHandle> liveProcesses = ProcessHandle.allProcesses();
        liveProcesses.filter(ProcessHandle::isAlive)
                .forEach(ph -> println(ph.pid()));
    }

    private static void psAuxGrepJava() throws IOException {
        ProcessBuilder psAux = new ProcessBuilder("ps", "aux");
        ProcessBuilder grepJava = new ProcessBuilder("grep", "java");
        List<Process> processes = ProcessBuilder.startPipeline(asList(psAux, grepJava));
        processes.forEach(p -> {
            try {
                println(new String(p.getInputStream().readAllBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
