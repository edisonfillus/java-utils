package com.company;

import java.util.List;

public class Hourglass {

    public static void main(String[] args) {
        List<List<Integer>> arr = List.of(
            List.of(1, 1, 1, 0, 0, 0),
            List.of(0, 1, 0, 0, 0, 0),
            List.of(1, 1, 1, 0, 0, 0),
            List.of(0, 0, 2, 4, 4, 0),
            List.of(0, 0, 0, 2, 0, 0),
            List.of(0, 0, 1, 2, 4, 0)
        );
        System.out.println(hourglassSum(arr));
    }

    public static int hourglassSum(List<List<Integer>> arr) {

        int maxHourglass = 0;

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                /*
                    [0,0][0,1][0,2]
                         [1,1]
                    [2,0][2,1][2],2]
                */
                int currHourglass = arr.get(row + 0).get(column + 0) +
                                    arr.get(row + 0).get(column + 1) +
                                    arr.get(row + 0).get(column + 2) +
                                    arr.get(row + 1).get(column + 1) +
                                    arr.get(row + 2).get(column + 0) +
                                    arr.get(row + 2).get(column + 1) +
                                    arr.get(row + 2).get(column + 2);
                if (currHourglass > maxHourglass) {
                    maxHourglass = currHourglass;
                }
            }
        }

        return maxHourglass;

    }
}
