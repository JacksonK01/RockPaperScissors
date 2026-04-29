package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class GameSubject implements Subject<Game> {
    List<Observer<Game>> observers;
    Game game;

    public GameSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer<Game> o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer<Game> o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        if (this.game == null) {
            throw new RuntimeException("Game Not Assigned");
        }

        observers.forEach((o) -> {
            o.update(game);
        });
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
