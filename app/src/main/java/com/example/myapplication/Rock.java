package com.example.myapplication;

public class Rock implements Item {
    @Override
    public int getWeight() {
        return 1;
    }

    @Override
    public int getThickness() {
        return 1;
    }

    @Override
    public int getSharpness() {
        return 0;
    }

    @Override
    public String getName() {
        return "Rock";
    }
}
