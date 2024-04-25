package com.example.phonecaddy;

import static org.junit.Assert.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DistancesTest {
    private Distances testDistancesMale;
    private Distances testDistancesFemale;

    @Before
    public void setUp() {
        testDistancesMale = new Distances(Gender.MENS);
        testDistancesFemale = new Distances(Gender.WOMENS);
    }

    @Test
    public void testInitialDistances() {
        assertEquals("Initial distance for SW should be 90", 90, testDistancesMale.sw);
        assertEquals("Initial distance for Driver should be 190", 190, testDistancesMale.driver);
    }

    @Test
    public void testBecomeIntermediate() {
        testDistancesMale.becomeIntermediate();
        assertEquals("Distance for SW at intermediate level should be 100", 100, testDistancesMale.sw);
        assertEquals("Distance for Driver at intermediate level should be 200", 200, testDistancesMale.driver);
    }

    @Test
    public void testBecomeAdvanced() {
        testDistancesMale.becomeAdvanced();
        assertEquals("Distance for SW at advanced level should be 110", 110, testDistancesMale.sw);
    }

    @Test
    public void testResetToBeginner() {
        testDistancesMale.becomePro(); // Set to pro level first
        testDistancesMale.resetToBeginner();
        assertEquals("After reset, distance for SW should be back to 90", 90, testDistancesMale.sw);
    }

    @Test
    public void testChangeToFemale() {
        // Initially should not be changed
        assertFalse("beenChanged should initially be false", testDistancesFemale.getBeenChanged());
        testDistancesFemale.changeToFemale();
        assertTrue("beenChanged should be true after change", testDistancesFemale.getBeenChanged());
        assertEquals("Distance for SW for female should decrease by 10", 80, testDistancesFemale.sw);
    }

    @Test
    public void testNoChangeForMale() {
        testDistancesMale.changeToFemale(); // Trying to change male should not change distances
        assertEquals("Distance for SW for male should not change", 90, testDistancesMale.sw);
    }
}