package com.example.myapplication;

public class UserInputStrategy implements Strategy {
    private final Item selectedItem;

    public UserInputStrategy(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    @Override
    public Item getItem() {
        return selectedItem;
    }
}