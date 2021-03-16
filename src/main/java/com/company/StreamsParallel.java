package com.company;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx8G"})
@Warmup(iterations = 1)
@Measurement(iterations = 10)
public class StreamsParallel {

    public static final int SAMPLE_SIZE = 1_000_000;

    private List<Integer> DATA_FOR_TESTING = null;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(StreamsParallel.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();


    }

    @Benchmark
    public void parallel() {
        var list = DATA_FOR_TESTING.stream()
                .parallel()
                .mapToDouble(r -> Math.pow(r, 3))
                .average();
    }

    @Benchmark
    public void sequential() {
        var list = DATA_FOR_TESTING.stream()
                .mapToDouble(r -> Math.pow(r, 3))
                .average();
    }

    @Setup
    public void setup() {
        DATA_FOR_TESTING = createData();
    }

    private List<Integer> createData() {
        return Stream.generate(() -> (int) Math.round(Math.random() * 100)).limit(SAMPLE_SIZE).collect(Collectors.toList());
    }

}
