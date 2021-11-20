package com.company;

import java.util.List;

public class ArrayManipulationWithMarkers {


    public static void main(String[] args) {
        List<List<Integer>> queries = List.of(
            List.of(1,5,3),
            List.of(4,8,7),
            List.of(6,9,1)
        );
        System.out.println(arrayManipulation(10, queries));
    }

    /**
     *
     *
     *    Queries       n = 10
     *     a b k
     *     1 5 3
     *     4 8 7
     *     6 9 1
     *
     *     index->	 1 2 3  4  5 6 7 8 9 10
     *            	[0,0,0, 0, 0,0,0,0,0, 0]
     *              [3,3,3, 3, 3,0,0,0,0, 0]
     *              [3,3,3,10,10,7,7,7,0, 0]
     *              [3,3,3,10,10,8,8,8,1, 0]
     *
     *     Result = 10
     *
     * If we have 1 query and it wants to add 100 to elements 2 through 4 inclusive in a 7-element array, we want to have:
     *
     * [0, 0, 100, 100, 100, 0, 0]
     * The idea is that we can represent this initially as:
     *
     * [0, 0, 100, 0, 0, -100, 0]
     * It's important to realize that this above array is not our final answer.
     * We will walk through the array from array[0] to array[6] to create our final answer.
     * When we reach array[2], it basically tells us that every element from here and to the right of it (array[2] to array[6])
     * should have 100 added to them. When we reach array[5], it tells us the same thing, except that every element should have
     * -100 added to it. By following these 2 rules, we get
     *
     * array[0] = 0;
     * array[1] = 0;
     * array[2] = 0 + 100 = 100;
     * array[3] = 0 + 100 = 100;
     * array[4] = 0 + 100 = 100;
     * array[5] = 0 + 100 - 100 = 0;
     * array[5] = 0 + 100 - 100 = 0;
     * giving us the final array of
     *
     * [0, 0, 100, 100, 100, 0, 0]
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {

        long[] manipulated = new long[n + 1];

        for (List<Integer> query : queries) {
            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);

            manipulated[a - 1] += k; // Mark start
            manipulated[b] -= k; // Mark end

        }
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += manipulated[i];
            max = Math.max(sum, max);
        }
        return max;

    }

}

