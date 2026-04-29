package com.example.myapplication;
public class StrategySelector {

    public Strategy selectStrategy(String toggle) {
        switch (toggle) {
            case "Random": return new RandomStrategy();
            case "Reflect": return new UserInputStrategy();
            default: throw new RuntimeException("Invalid Toggle");
        }
    }
}