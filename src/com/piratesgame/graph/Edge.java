package com.piratesgame.graph;

import com.piratesgame.graph.exceptions.EdgeLoopException;
import com.piratesgame.graph.vertices.Vertex;

public class Edge {

    private Vertex vertexOne;

    private Vertex vertexTwo;

    private int weight;

    public Edge (Vertex one, Vertex two){
        this(one, two, 1);
    }

    public Edge (Vertex one, Vertex two, int i){
        int result = one.getLabel().compareToIgnoreCase(two.getLabel());
        if(result == 0){
            throw new EdgeLoopException();
        }
        if(result < 0){
            this.setVertexOne(one);
            this.setVertexTwo(two);
            this.setWeight(i);
        }
        else if (result > 0) {
        this.setVertexOne(two);
        this.setVertexTwo(one);
        this.setWeight(i);
        }
    }

    public void setWeight(int i){
        this.weight = i;
    }

    public void setVertexOne(Vertex v){
        this.vertexOne = v;
    }

    public void setVertexTwo(Vertex v){
        this.vertexTwo = v;
    }

    public int getWeight(){
        return this.weight;
    }

    public Vertex getVertexOne(){
        return this.vertexOne;
    }

    public Vertex getVertexTwo(){
        return this.vertexTwo;
    }

    public String toString(){
        return "({"+getVertexOne().getLabel()+", "+getVertexTwo().getLabel()+"}, "+getWeight()+")";
    }

    public int hashCode(){
        return (getVertexOne().getLabel()+getVertexTwo().getLabel()).hashCode();
    }

    public Vertex getNeighbour(Vertex v){
        if(v.equals(this.vertexOne)){
            return this.vertexTwo;
        }
        else if (v.equals(this.vertexTwo)){
            return this.vertexOne;
        }
        return null;
    }

    public boolean equals(Edge e){
        if(e.hashCode() == this.hashCode()){
            return true;
        }
        return false;
    }

    public boolean equals(Object c){
        if(!(c instanceof Edge)){
            return false;
        }
        Edge e = (Edge) c;
        if(e.hashCode() == this.hashCode()){
            return true;
        }
        return false;
    }

}
