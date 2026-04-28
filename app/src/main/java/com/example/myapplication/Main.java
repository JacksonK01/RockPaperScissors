package com.example.myapplication;

public class Main {
    public static void main(String[] args) {
        Item paper = new Paper();
        Item rock = new Rock();
        Item scissor = new Scissor();

        GameSubject subject = new GameSubject();

        subject.registerObserver((game) -> {
            if (game.getItem1().getWeight() < game.getItem2().getWeight()) {
                game.setP1Score(game.getP1Score() + 1);
            } else if (game.getItem2().getWeight() < game.getItem1().getWeight()) {
                game.setP2Score(game.getP2Score() + 1);
            }
        });

        subject.registerObserver((game) -> {
            if (game.getItem1().getThickness() > game.getItem2().getSharpness()) {
                game.setP1Score(game.getP1Score() + 1);
            } else if (game.getItem2().getThickness() > game.getItem1().getSharpness()) {
                game.setP2Score(game.getP2Score() + 1);
            }
        });

        subject.registerObserver((game) -> {
            if (game.getItem1().getSharpness() > game.getItem2().getThickness()) {
                game.setP1Score(game.getP1Score() + 1);
            } else if (game.getItem2().getSharpness() > game.getItem1().getThickness()) {
                game.setP2Score(game.getP2Score() + 1);
            }
        });

        Game[] matches = {
                new Game(paper, rock),
                new Game(rock, scissor),
                new Game(scissor, paper)
        };

        for (Game g : matches) {
            subject.setGame(g);
            subject.notifyObservers();
            System.out.println(g.getItem1().getName() + " vs " + g.getItem2().getName() +
                    " | Score: P1=" + g.getP1Score() + " P2=" + g.getP2Score());
        }
    }
}