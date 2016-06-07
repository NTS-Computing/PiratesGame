package com.piratesgame.graph.collectibles;

public class Collectible {

    protected int Amount = 0;
    protected int limit = 0;

    public void modifyAmount(int size){
        size = Math.abs(size);

        this.Amount += size;
    }

    public void increase(int size){
        this.modifyAmount(size);
    }

    public void decrease(int size){
        size = Math.abs(size);

        this.modifyAmount(size * -1);
    }

    public void setLimit(int max){
        max = Math.abs(max);

        this.limit = max;
    }
}
