package com.company;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.profile.HotspotMemoryProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx8G"})
@Warmup(iterations = 1)
@Measurement(iterations = 10)
public class CollectionsPerformance {

    public static final int SAMPLE_SIZE = 1_000;

    private List<Integer> DATA_FOR_TESTING = null;

    public static void main(String ...args) throws IOException, RunnerException {
        Options opt = new OptionsBuilder()
                .include(CollectionsPerformance.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();

    }

    @Benchmark
    public void arrayListAddWithoutCapacity(){
        List<Integer> list = new ArrayList<Integer>();
        DATA_FOR_TESTING.forEach(list::add);
    }

    @Benchmark
    public void arrayListAddWithCapactity(){
        List<Integer> list = new ArrayList<Integer>(SAMPLE_SIZE << 1);
        DATA_FOR_TESTING.forEach(list::add);
    }

    @Benchmark
    public void linkedListAdd(){
        LinkedList<Integer> list = new LinkedList<>();
        DATA_FOR_TESTING.forEach(list::add);
    }


    @Benchmark
    public void hashSetAddWithoutCapactity(){
        Set<Integer> list = new HashSet<>();
        DATA_FOR_TESTING.forEach(list::add);
    }

    @Benchmark
    public void hashSetAddWithCapactity(){
        Set<Integer> list = new HashSet<>(SAMPLE_SIZE << 1);
        DATA_FOR_TESTING.forEach(list::add);
    }

    @Benchmark
    public void treeSetAdd(){
        Set<Integer> list = new TreeSet<>();
        DATA_FOR_TESTING.forEach(list::add);
    }


    @Setup
    public void setup() {
        DATA_FOR_TESTING = createData();
    }

    private List<Integer> createData() {
        return Stream.iterate(1,i->i+1).limit(SAMPLE_SIZE).collect(Collectors.toList());
    }

}
