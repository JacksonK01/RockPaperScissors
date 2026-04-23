package com.example.myapplication;

public interface Item {
    //Weight for when paper beats rock
    //Lighter item wins
    int getWeight();

    //Thickness for when rock beats scissors
    //Thicker vs sharp
    int getThickness();

    //For when scissors beats paper
    //Sharper vs thickness
    int getSharpness();

    String getName();
}
