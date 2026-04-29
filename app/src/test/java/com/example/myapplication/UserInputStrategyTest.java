package com.example.myapplication;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserInputStrategyTest {
    Item testInput;

    //Tests getItem for user input of a rock
    @Test
    public void testUserInputRock(){
        Item testInput = new Rock();
        UserInputStrategy testStrategy = new UserInputStrategy(testInput);
        assertTrue(testStrategy.getItem() instanceof Rock);
    }

    //Tests getItem for user input of paper
    @Test
    public void testUserInputPaper(){
        Item testInput = new Paper();
        UserInputStrategy testStrategy = new UserInputStrategy(testInput);
        assertTrue(testStrategy.getItem() instanceof Paper);
    }

    //Tests getItem for user input of scissors
    @Test
    public void testUserInputScissor(){
        Item testInput = new Scissor();
        UserInputStrategy testStrategy = new UserInputStrategy(testInput);
        assertTrue(testStrategy.getItem() instanceof Scissor);
    }

}
