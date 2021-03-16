package com.company;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsMerge {

    public static void main(String[] args) {
        var part1 = Stream.of('Z', 'X', 'Y','A');
        var part2 = Stream.of('D', 'E', 'F','I');
        var part3 = Stream.of('I', 'A', 'H','B');
        var part4= Stream.of('C','K','B','Z');

        var merged = Stream.of(part1, part2, part3, part4).flatMap(i -> i);

        var result = merged
                .distinct()
                .sorted()
                .map(Character::toLowerCase)
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString
                ));

        System.out.println(result);
    }

}
