package com.example.myapplication;

public interface Subject<T> {
    void registerObserver(Observer<T> o);

    void removeObserver(Observer<T> o);

    void notifyObservers();
}
