package com.piratesgame.collectibles;

public class Collectible {

    protected int Amount = 0;
    protected int limit = 0;
//  Better vertion of increase / decrease
//    public void change(int size){
//        if(Amount + size>limit){
//            this.Amount = this.limit;
//            return;
//        }
//        this.Amount = this.Amount + size;
//    }
//

    public void increase(int size){
        if (Amount + size > limit){
            this.Amount = this.limit;
            return;
        }

        this.Amount = this.Amount + size;
    }

    public void decrease(int size){
        if (Amount - size < 0){
            this.Amount = 0;
            return;
        }

        this.Amount = this.Amount - size;
    }

    public void setLimit(int max){
        max = Math.abs(max);

        this.limit = max;
    }
    /**/
    public int quantity(){
        return Amount;
    }
}
