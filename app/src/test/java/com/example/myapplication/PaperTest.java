package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PaperTest {
    Paper paper;
    @Before
    public void setup() {
        paper = new Paper();
    }
    @Test
    public void testWeight() {
        assertEquals(0, paper.getWeight());
    }
    @Test
    public void testThickness() {
        assertEquals(0, paper.getThickness());
    }
    @Test
    public void testSharpness() {
        assertEquals(0, paper.getSharpness());
    }
    @Test
    public void testName() {
        assertEquals("Paper", paper.getName());
    }
}
