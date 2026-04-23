package com.example.myapplication;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class BehaviorTests {
    @Test
    public void testRockVsPaper() {
        Item rock = new Rock();
        Item paper = new Paper();

        assertTrue(paper.getWeight() < rock.getWeight());
        assertFalse(paper.getWeight() < rock.getWeight());
    }

    @Test
    public void testRockVsScissor() {
        Item rock = new Rock();
        Item scissor = new Scissor();

        assertTrue(rock.getThickness() > scissor.getSharpness());
        assertFalse(rock.getThickness() < scissor.getSharpness());
    }
}
