package com.example.myapplication;

public class Paper implements Item {

    @Override
    public String getName() {
        return "Paper";
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
