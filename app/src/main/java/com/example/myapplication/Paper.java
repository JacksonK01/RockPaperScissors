package com.example.myapplication;

public class Paper implements Item {
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
        return 2;
    }

    @Override
    public String getName() {
        return "Paper";
    }
}
