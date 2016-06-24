package com.piratesgame.helpers;

import com.piratesgame.graph.Edge;
import com.piratesgame.graph.vertices.Vertex;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Scanner;

public class Cli {
    int numberOfMoves = 0;
    public static void movingboat(){

    }

    public static int getUserChoiceForMovment(){
        Scanner Scan = new Scanner(System.in);
        System.out.println ("Enter your choice, using a single interger.");
        return Integer.parseInt(Scan.nextLine());

    }
    public static Edge getOptionsForMovementandchoice(Vertex v){
        ArrayList<Edge> destination = v.getNeighbourhood();
        int loopnumber = 0;
        int IndexNumber = 0;
        while (destination.size() >= loopnumber) {
            String Destin = IndexNumber + ":" + destination.get(loopnumber);
            System.out.println(Destin);
            loopnumber = loopnumber + 1;
        }
            int choice = getUserChoiceForMovment();
            Edge des = destination.get(choice -1);
            return des;

    }
}
