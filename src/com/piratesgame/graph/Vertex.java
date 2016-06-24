package com.piratesgame.graph;

import com.piratesgame.graph.exceptions.NoEdgeException;

import java.util.ArrayList;

public class Vertex {

    private String label;

    private ArrayList<Edge> incidenceNeighbourhood = new ArrayList<Edge>();

    public Vertex(){
        this.setLabel(null);
    }

    public Vertex (String s){
        this.setLabel(s);
    }

    public void setLabel(String s){
        this.label = s;
    }

    public void addNeighbour(Edge e){
        this.incidenceNeighbourhood.add(e);
    }

    public String getLabel(){
        return this.label;
    }

    public ArrayList getNeighbourhood(){
        return this.incidenceNeighbourhood;
    }

    public Edge getNeighbour(int i){
        this.guardAgainstNoNeighbours();
        i--;
        return this.incidenceNeighbourhood.get(i);
    }

    public Edge getNeighbour(Edge e){
        if (incidenceNeighbourhood.contains(e)){
            return e;
        }
        throw new NoEdgeException();
    }

    public void removeNeighbour(int i){
        this.guardAgainstNoNeighbours();
        i--;
        this.incidenceNeighbourhood.remove(i);
    }

    public void removeNeighbour(Edge e){
        this.guardAgainstNoNeighbours();
        if (this.incidenceNeighbourhood.contains(e)){
            this.incidenceNeighbourhood.remove(e);
        }
    }

    public boolean containsNeighbour(Edge e){
        if (incidenceNeighbourhood.contains(e)){
            return true;
        }
        return false;
    }

    public int getNeighbourCount(){
        return incidenceNeighbourhood.size();
    }

    public int hashCode(){
        return this.getLabel().hashCode();
    }

    public String toString(){
        return "Vertex: "+this.getLabel();
    }

//    public int compareTo(){
//        return
//    }

    public boolean equals(Object comparable){
        if(!(comparable instanceof Vertex)){
            return false;
        }

        Vertex v =(Vertex) comparable;

        if(v.getLabel().equalsIgnoreCase(this.getLabel())){
            return true;
        }

        return false;
    }

    public void guardAgainstNoNeighbours(){
        if (this.incidenceNeighbourhood.size() == 0){
            throw new NoEdgeException();
        }
    }
}
