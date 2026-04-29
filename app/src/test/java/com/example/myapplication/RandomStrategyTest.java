package com.example.myapplication;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RandomStrategyTest {
    RandomStrategy testStrategy;

    //Tests that getItem doesn't return null
    @Test
    public void testRandomStrategyNotNull() {
        RandomStrategy testStrategy = new RandomStrategy();
        assertNotNull(testStrategy.getItem());
    }

    //Tests that getItem gives each type of item at least once with a very large number of iterations
    @Test
    public void testRandomStrategyAllTypes() {
        RandomStrategy testStrategy = new RandomStrategy();
        boolean foundRock = false;
        boolean foundPaper = false;
        boolean foundScissor = false;

        for (int i = 0; i < 1000; i++) {
            Item item = testStrategy.getItem();
            if (item instanceof Rock)    foundRock = true;
            if (item instanceof Paper)   foundPaper = true;
            if (item instanceof Scissor) foundScissor = true;
        }
        assertTrue(foundRock);
        assertTrue(foundPaper);
        assertTrue(foundScissor);
    }
}
