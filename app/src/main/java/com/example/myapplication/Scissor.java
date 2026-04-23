package com.example.myapplication;

public class Scissor implements Item {
    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public int getThickness() {
        return 0;
    }

    @Override
    public int getSharpness() {
        return 1;
    }

    @Override
    public String getName() {
        return "Scissor";
    }
}
