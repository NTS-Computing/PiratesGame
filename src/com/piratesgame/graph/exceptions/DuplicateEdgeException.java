package com.piratesgame.graph.exceptions;

public class DuplicateEdgeException extends RuntimeException{
    public DuplicateEdgeException(){
        super();
    }
    public DuplicateEdgeException(String message){
        super(message);
    }
}
