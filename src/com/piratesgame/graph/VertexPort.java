package com.piratesgame.graph;

public class VertexPort extends Vertex{
    //this constructor doesnt work
    public VertexPort(Vertex v){
        super();
    }

    public VertexPort (String s){
        this.setLabel(s);
    }
}
