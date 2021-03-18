package com.company;

import java.io.Console;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOConsole {

    public void console(){
        Console console = System.console();
        if(console == null) {
            System.out.println("Console is not supported!");
            return;
        }
        PrintWriter out = console.writer();
        out.println("To quit type: exit");
        out.println("Type value and press Enter: ");
        String txt;
        while(!(txt = console.readLine()).equals("exit")){
            out.println("Echo: " + txt);
        }
    }

    public void scanner() {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
