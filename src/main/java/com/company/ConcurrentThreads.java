package com.company;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcurrentThreads {

    public static void main(String[] args) {
        AtomicInteger sequence = new AtomicInteger(0);

        Callable<String> task = () -> {
            int threadId = sequence.getAndIncrement();
            int random = ThreadLocalRandom.current().nextInt(100);

            return String.format("ThreadID: %d, Random: %d", threadId, random);
        };

        List<Callable<String>> tasks = Stream.generate(() -> task).limit(100).collect(Collectors.toList());

        ExecutorService executor = Executors.newFixedThreadPool(6);

        try {
            List<Future<String>> results = executor.invokeAll(tasks);
            results.forEach(result -> {
                try {
                    System.out.println(result.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
            executor.shutdown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
