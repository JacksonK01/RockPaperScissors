package com.example.myapplication;

public class Game {
    private Item item1;
    private Item item2;
    private int p1Score = 0;
    private int p2Score = 0;

    public Game(Item item1, Item item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public Item getItem1() {
        return item1;
    }

    public Item getItem2() {
        return item2;
    }

    public int getP1Score() {
        return p1Score;
    }

    public int getP2Score() {
        return p2Score;
    }

    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }

    public void setP2Score(int p2Score) {
        this.p2Score = p2Score;
    }
}