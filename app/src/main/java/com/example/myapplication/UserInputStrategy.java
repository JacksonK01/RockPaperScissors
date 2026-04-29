package com.example.myapplication;

public class UserInputStrategy implements Strategy {
    private Item selectedItem;

    @Override
    public Item getItem() {
        if(selectedItem == null) {
            return new RandomStrategy().getItem();
        }

        return selectedItem;
    }

    @Override
    public void afterTurn(Item otherPlayer) {
        this.selectedItem = otherPlayer;
    }
}