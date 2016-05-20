package com.piratesgame.graph;

public class EdgeLoopException extends RuntimeException{
    public EdgeLoopException(){
        super();
    }
    public EdgeLoopException(String message){
        super(message);
    }
}
