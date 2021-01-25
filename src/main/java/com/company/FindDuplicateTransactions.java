package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicateTransactions {

    public static void main(String[] args){

        List<String> transactions = Arrays.asList("AAAA","AAAB", "AAAA");
        printMatrix(findDuplicateTransactions(transactions));

    }


    static List<List<String>> findDuplicateTransactions(List<String> transactions){
        List<List<String>> groups = new ArrayList<>();

        for(String transaction : transactions) {

            var groupWithDuplicate = groups.stream().filter(group->
                group.stream().anyMatch(element->
                    isTransactionDuplicate(element,transaction)
                )
            ).findFirst();

            if(groupWithDuplicate.isPresent()){
                groupWithDuplicate.get().add(transaction);
            } else {
                groups.add(new ArrayList<String>(List.of(transaction)));
            }

            /*
            List<String> groupWithDuplicate = null;
            findFirst:
            for(var group : groups){
                for(var element: group){
                    if(isTransactionDuplicate(element,transaction)){
                        groupWithDuplicate = group;
                        break findFirst;
                    }
                }
            }

            if(groupWithDuplicate != null){
                groupWithDuplicate.add(transaction);
            } else {
                groups.add(new ArrayList<String>(Arrays.asList(transaction)));
            }
            */


        }

        return groups;
    }

    static void printMatrix(List<List<String>> matrix) {
        for(List<String> transactions : matrix){
            for(String transaction : transactions){
                System.out.print(transaction + " ");
            }
            System.out.println();
        }
    }

    static boolean isTransactionDuplicate(String element, String transaction){
        return element.equals(transaction);
    }

}
