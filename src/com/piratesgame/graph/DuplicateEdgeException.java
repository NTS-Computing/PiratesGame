package com.piratesgame.graph;

public class DuplicateEdgeException extends RuntimeException{
    public DuplicateEdgeException(){
        super();
    }
    public DuplicateEdgeException(String message){
        super(message);
    }
}
