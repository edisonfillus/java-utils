package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOperations {

    public static void main(String[] args) {
        var listA = Arrays.asList("A", "B", "D", "D", "E", "F", "G", "Z");
        var listB = Arrays.asList("C", "D", "D", "E", "H", "I", "Z");
        System.out.println(intersection(listA, listB));
        System.out.println(union(listA, listB));
    }

    private static java.util.List<String> union(java.util.List<String> listA, java.util.List<String> listB) {
        return Stream.concat(listA.stream(),listB.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

    }

    private static java.util.List<String> intersection(java.util.List<String> listA, java.util.List<String> listB) {
        return listA.stream()
                .distinct()
                .filter(listB::contains)
                .collect(Collectors.toList());
        /*

        List<String> result = new ArrayList<>();

        int cursorOfA = 0, cursorOfB = 0;

        while(cursorOfA != listA.size() && cursorOfB != listB.size()){

            String elementOfA = listA.get(cursorOfA);
            String elementOfB = listB.get(cursorOfB);

            if(elementOfA.compareTo(elementOfB) < 0){
                cursorOfA++;
            } else if(elementOfB.compareTo(elementOfA) < 0){
                cursorOfB++;
            } else {
                result.add(elementOfA);
                cursorOfA++;
                cursorOfB++;
            }
        }


        return result;
        */
    }
}
