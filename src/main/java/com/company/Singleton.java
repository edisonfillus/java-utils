package com.company;

import java.util.List;

public class Singleton {

    private static List<String> instance;

    static List<String> getInstance(){
        if(instance==null){
            instance = List.of("Hello"," ", "Singleton");
        }
        return instance;
    }

}
