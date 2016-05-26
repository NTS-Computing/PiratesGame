package com.piratesgame.graph.exceptions;

public class NoEdgeException extends RuntimeException{
    public NoEdgeException(){
        super();
    }
    public NoEdgeException(String message){
        super(message);
    }
}
