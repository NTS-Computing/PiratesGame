package com.piratesgame.helpers;

import com.piratesgame.graph.Edge;
import com.piratesgame.graph.Vertex;

import java.util.ArrayList;
import java.util.Scanner;

public class Cli {
    int numberOfMoves = 0;
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
    public static void getOptionsForMovement(Vertex v){
        ArrayList<Edge> destination = v.getNeighbourhood();
        for(Edge e : destination){
     //       System.out.println(e.getNeighbour(v).getLabel());
        }

    }
}
