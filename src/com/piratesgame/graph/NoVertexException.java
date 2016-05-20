package com.piratesgame.graph;

public class NoVertexException extends RuntimeException{
    public NoVertexException(){
        super();
    }
    public NoVertexException(String message){
        super(message);
    }
}
