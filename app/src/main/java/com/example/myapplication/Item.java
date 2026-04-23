package com.example.myapplication;

public interface Item {
    //Weight for when paper beats rock
    //Lighter item wins
    public int getWeight();

    //Thickness for when rock beats scissors
    //Thicker vs sharp
    public int getThickness();

    //For when scissors beats paper
    //Sharper vs thickness
    public int getSharpness();
}
