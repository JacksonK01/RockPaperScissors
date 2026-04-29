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
    public void testName() {
        assertEquals("Paper", paper.getName());
    }
}
