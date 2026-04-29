package com.example.myapplication;

import java.util.Random;
public class RandomStrategy implements Strategy{

    @Override
    public Item getItem() {
        Random random= new Random();
        int num = random.nextInt(3);
        if(num == 0){
            return new Paper();
        }
        else if (num == 1){
            return new Scissor();
        }
        else{
            return new Rock();
        }
    }

    @Override
    public void afterTurn(Item otherPlayer) {}
}
