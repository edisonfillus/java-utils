package com.company;

public class Letterify {
    public static void main(String[] args) {
        System.out.println(letterify("???"));
        System.out.println(letterify("???").matches("[a-z][a-z][a-z]"));

        System.out.println(numerify("###"));
        System.out.println(numerify("###").matches("[0-9][0-9][0-9]"));

        System.out.println(bothify("Test?#"));
        System.out.println(bothify("Test?#").matches("Test[a-z][0-9]"));
    }


    public static String letterify(String letterString) {
        if(letterString == null || letterString.isEmpty()) return "";
        StringBuilder result = new StringBuilder();
        char[] letterArray = letterString.toCharArray();
        for(char elem : letterArray){
            if(elem == '?'){
                char randomLetter = (char) ('a' + Math.random() * ('z'-'a' + 1));
                result.append(randomLetter);
            } else {
                result.append(elem);
            }
        }

        return result.toString();
    }

    public static String numerify(String numberString) {
        if(numberString == null || numberString.isEmpty()) return "";
        StringBuilder result = new StringBuilder();
        char[] numberArray = numberString.toCharArray();
        for(char elem : numberArray){
            if(elem == '#'){
                char randomLetter = (char) ('0' + Math.random() * ('9'-'0' + 1));
                result.append(randomLetter);
            } else {
                result.append(elem);
            }
        }

        return result.toString();
    }

    public static String bothify(String string) {
        if(string == null || string.isEmpty()) return "";
        StringBuilder result = new StringBuilder();
        char[] mixedArray = string.toCharArray();
        for(char elem : mixedArray){
            if(elem == '?'){
                char randomLetter = (char) ('a' + Math.random() * ('z'-'a' + 1));
                result.append(randomLetter);
            } else if (elem == '#'){
                char randomLetter = (char) ('0' + Math.random() * ('9'-'0' + 1));
                result.append(randomLetter);
            } else {
                result.append(elem);
            }
        }

        return result.toString();
    }



}
