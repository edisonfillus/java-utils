package com.company;

import java.util.Arrays;
import java.util.stream.Stream;

public class Anagram {

    public static void main(String ...args){
        //System.out.println(isAnagram("loco boco", "colo cobo"));
        //System.out.println(isAnagram("abra", "raab"));
        //System.out.println(isAnagram("loco", "col"));
        //System.out.println(isAnagram("loco", "lico"));
        System.out.println(isAnagram("anagramm","marganaa"));
    }


    public static boolean isAnagram(String a, String b) {

        a = a.replace("//s", "");
        b = b.replace("//s", "");

        if (a.length() != b.length()) return false;

        char[] arrayA = a.toLowerCase().toCharArray();
        char[] arrayB = b.toLowerCase().toCharArray();

        int[] buckets = new int[256];

        for(int i = 0; i < arrayA.length; i++){
            buckets['a' + arrayA[i]]++;
            buckets['a' + arrayB[i]]--;
        }

        for(int elem : buckets){
            if(elem != 0) {
                return false;
            }
        }
        return true;

        /*

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        return Arrays.equals(arrayA,arrayB);

        */


    }


}