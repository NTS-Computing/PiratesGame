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
    public static Vertex getOptionsForMovementandchoice(Vertex v){
        ArrayList<Edge> destination = v.getNeighbourhood();
        System.out.println(destination.size());
        /*loop number should be 0 as
        when it is set to one
        it causes a outofbounds exeption,
        arrylists start from 0
         */
        int loopnumber = 1;
        int IndexNumber = 1;
        while (destination.size() >= loopnumber) {
            String Destin =  "";
            Edge Choice = destination.get(loopnumber - 1);
            if (Choice.getVertexOne() == v){
                Destin = IndexNumber + " :" + Choice.getVertexTwo().getLabel();
            }else if (Choice.getVertexOne() ==v){
                Destin = IndexNumber + " :" + Choice.getVertexOne().getLabel();
            }
            System.out.println(Destin);
            loopnumber = loopnumber + 1;
            IndexNumber = IndexNumber + 1;

        }
            int choice = getUserChoiceForMovment();
            Edge des = destination.get(choice -1);
            Vertex endVertex = movealong(des,v);
        return endVertex;

    }
    public static Vertex movealong(Edge TravelAlong,Vertex Start){
        int travelwieght = TravelAlong.getWeight();
        if (Start == TravelAlong.getVertexOne()){
            return TravelAlong.getVertexTwo();
        }else {
            return TravelAlong.getVertexTwo();
        }



    }
}
