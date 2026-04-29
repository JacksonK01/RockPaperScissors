package com.example.myapplication;

import java.util.Random;
public class StrategySelector {

    public Strategy selectStrategy(Item item){
        Random random= new Random();
        int num = random.nextInt(2);
        if (num == 0){
            return new RandomStrategy();
        }
        else{
            return new UserInputStrategy(item);
        }
        }
}
