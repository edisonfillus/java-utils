package com.company;

public class FormatStringConsole {

    public static void main(String ...args){
        printReport();
        printMultiplicationTable(2);
    }

    public static void printMultiplicationTable(int n){
        for(int i = 1 ; i <= 10 ; i++){
            System.out.println(String.format("%d x %d = %d",n,i,n*i));
        }
    }

    public static void printReport(){
        String[] categories = new String[]{"java", "python", "c++"};
        int[] values = new int[]{100,56,78};

        System.out.println("================================");
        for(int i=0;i<3;i++){
            System.out.print(String.format("%-15s",categories[i]));
            System.out.print(String.format("%03d",values[i]));
            System.out.println("");
        }
        System.out.println("================================");
    }

}
