package com.company;

public class Sort {

    public static void main(String ...args){
        char[] arr = "defbac".toCharArray();
        bublleSort(arr);
        System.out.println(arr);
    }


    public static void bublleSort(char[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[i] > arr[j]){
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

}
