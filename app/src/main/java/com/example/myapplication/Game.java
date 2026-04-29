package com.example.myapplication;

public class Game {
    private Item item1;
    private Item item2;
    private String winner;

    public Game(Item item1, Item item2) {
        this.item1 = item1;
        this.item2 = item2;
        this.winner = "Tie";
    }

    public Item getItem1() {
        return item1;
    }

    public Item getItem2() {
        return item2;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getWinner() {
        return this.winner;
    }
}