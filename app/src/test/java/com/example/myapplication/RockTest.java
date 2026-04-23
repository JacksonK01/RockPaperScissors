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
    public void testWeight() {
        assertEquals(1, rock.getWeight());
    }
    @Test
    public void testThickness() {
        assertEquals(2, rock.getThickness());
    }
    @Test
    public void testSharpness() {
        assertEquals(0, rock.getSharpness());
    }
    @Test
    public void testName() {
        assertEquals("Rock", rock.getName());
    }
}
