package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game testGame;
    private Rock testRock;
    private Scissor testScissors;

    @Before
    public void setUp() {
        testRock = new Rock();
        testScissors = new Scissor();
        testGame = new Game(testRock, testScissors);
    }

    //Tests if getItem1 returns the correct item
    @Test
    public void testGetItem1() {
        assertEquals(testRock, testGame.getItem1());
    }

    //Tests if getItem2 returns the correct item
    @Test
    public void testGetItem2() {
        assertEquals(testScissors, testGame.getItem2());
    }

    //Tests if the default winner is initialized correctly
    @Test
    public void testDefaultWinner() {
        assertEquals("Tie", testGame.getWinner());
    }

    //Tests if setWinner works correctly
    @Test
    public void testSetWinner() {
        testGame.setWinner("Player1");
        assertEquals("Player1", testGame.getWinner());
    }
}
