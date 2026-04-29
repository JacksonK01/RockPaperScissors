package com.example.myapplication;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class RockTest {
    Rock rock;
    @Before
    public void setup() {
        rock = new Rock();
    }
    @Test
    public void testName() {
        assertEquals("Rock", rock.getName());
    }
}
