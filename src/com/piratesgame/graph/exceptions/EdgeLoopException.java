package com.piratesgame.graph.exceptions;

public class EdgeLoopException extends RuntimeException{
    public EdgeLoopException(){
        super();
    }
    public EdgeLoopException(String message){
        super(message);
    }
}
