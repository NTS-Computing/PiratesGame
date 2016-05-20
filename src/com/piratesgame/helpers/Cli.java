package com.piratesgame.helpers;

import java.util.Scanner;

public class Cli {
    public static String getUserInput(String msg){
        System.out.println(msg + ": ");

        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        in.close();

        return userInput;
    }

    public static int getUserInputInt(String msg){
        return Integer.parseInt(getUserInput(msg));
    }
}
