package com.piratesgame.graph;

public class VertexSea extends Vertex {
    //this constructor doesnt work
    public VertexSea(Vertex v){
        this.setLabel(v.getLabel());
    }

    public VertexSea (String s){
        this.setLabel(s);
    }
}
