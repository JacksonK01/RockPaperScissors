package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScissorTest {
    Scissor scissor;
    @Before
    public void setup() {
        scissor = new Scissor();
    }
    @Test
    public void testWeight() {
        assertEquals(0, scissor.getWeight());
    }
    @Test
    public void testThickness() {
        assertEquals(0, scissor.getThickness());
    }
    @Test
    public void testSharpness() {
        assertEquals(1, scissor.getSharpness());
    }
    @Test
    public void testName() {
        assertEquals("Scissor", scissor.getName());
    }
}
