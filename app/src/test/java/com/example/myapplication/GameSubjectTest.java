package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameSubjectTest {

    private GameSubject testGameSubject;
    private Game testGame;

    //A test observer that can be instantiated
    private static class TestObserver implements Observer<Game> {
        int updateCount = 0;
        Game lastGame = null;

        @Override
        public void update(Game g) {
            updateCount++;
            lastGame = g;
        }
    }

    @Before
    public void setUp() {
        testGameSubject = new GameSubject();
        testGame = new Game(new Rock(), new Scissor());
    }

    //Tests if registerObserver works correctly
    @Test
    public void testRegisterObserver() {
        TestObserver observer = new TestObserver();
        testGameSubject.registerObserver(observer);
        assertEquals(1, testGameSubject.observers.size());
    }

    //Tests if removeObserver works correctly
    @Test
    public void testRemoveObserver() {
        TestObserver observer = new TestObserver();
        testGameSubject.registerObserver(observer);
        testGameSubject.removeObserver(observer);
        assertEquals(0, testGameSubject.observers.size());
    }

    //Tests if multiple observers can be notified
    @Test
    public void testNotifyObservers() {
        TestObserver observer1 = new TestObserver();
        TestObserver observer2 = new TestObserver();
        testGameSubject.registerObserver(observer1);
        testGameSubject.registerObserver(observer2);
        testGameSubject.setGame(testGame);
        testGameSubject.notifyObservers();

        assertEquals(1, observer1.updateCount);
        assertEquals(1, observer2.updateCount);
    }

    //Tests that the correct exception is thrown when observers are notified while there isn't a game
    @Test(expected = RuntimeException.class)
    public void testNotifyObserversNullGame() {
        testGameSubject.registerObserver(new TestObserver());
        testGameSubject.notifyObservers();
    }

}
