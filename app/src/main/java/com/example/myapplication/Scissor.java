package com.example.myapplication;

public class Scissor implements Item {
    @Override
    public String getName() {
        return "Scissor";
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
