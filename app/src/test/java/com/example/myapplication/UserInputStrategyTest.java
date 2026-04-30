package com.example.myapplication;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserInputStrategyTest {

    //Tests if this strategy returns right item when a user previously selected a rock
    @Test
    public void testUserInputRock(){
        UserInputStrategy testStrategy = new UserInputStrategy();
        testStrategy.afterTurn(new Rock());
        assertTrue(testStrategy.getItem() instanceof Rock);
    }

    //Tests if this strategy returns right item when a user previously selected paper
    @Test
    public void testUserInputPaper(){
        UserInputStrategy testStrategy = new UserInputStrategy();
        testStrategy.afterTurn(new Paper());
        assertTrue(testStrategy.getItem() instanceof Paper);
    }

    //Tests if this strategy returns right item when a user previously selected scissors
    @Test
    public void testUserInputScissor(){
        UserInputStrategy testStrategy = new UserInputStrategy();
        testStrategy.afterTurn(new Scissor());
        assertTrue(testStrategy.getItem() instanceof Scissor);
    }
}
