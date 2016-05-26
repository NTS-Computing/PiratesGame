package com.piratesgame.graph.exceptions;

public class NoVertexException extends RuntimeException{
    public NoVertexException(){
        super();
    }
    public NoVertexException(String message){
        super(message);
    }
}
