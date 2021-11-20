package com.company;

public class PrimeEfficient {

    public static boolean primality(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i = i+2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }
}
