package com.company;

public class SherlockAnagrams {

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("kkkk")); //10
        System.out.println(sherlockAndAnagrams("ifailuhkqq")); //3
    }

    public static int sherlockAndAnagrams(String s) {
        int anagrams = 0;
        // Combinations
        for (int size = 1; size < s.length(); size++) {
            for (int leftCursor = 0; leftCursor <= s.length() - size; leftCursor++) {
                for (int rightCursor = leftCursor + 1; rightCursor <= s.length() - size; rightCursor++) {
                    String leftElement = s.substring(leftCursor, leftCursor + size);
                    String rightElement = s.substring(rightCursor, rightCursor + size);
                    if (isAnagram(leftElement, rightElement)) {
                        anagrams++;
                    }
                }
            }
        }
        return anagrams;

    }

    private static boolean isAnagram(String a, String b) {
        if (a.equals(b)) {
            return true;
        }
        int[] buckets = new int[256];
        for (int i = 0; i < a.length(); i++) {
            buckets[a.charAt(i)]++;
            buckets[b.charAt(i)]--;
        }
        for (int elem : buckets) {
            if (elem != 0) {
                return false;
            }
        }
        return true;
    }
}
