package com.example.myapplication;

public interface Strategy {
    Item getItem();
    void afterTurn(Item otherPlayer);
}
