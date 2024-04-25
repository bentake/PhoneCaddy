package com.example.phonecaddy;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GolferTest {
    private Golfer maleGolfer;
    private Golfer femaleGolfer;

    @Before
    public void setUp() {
        // Create instances of golfer for a male and female with specific attributes
        maleGolfer = new Golfer(new Person("John", "Doe", 30, Gender.MENS), TypeOfGolfer.ADVANCED, DominantHand.RIGHT);
        femaleGolfer = new Golfer(new Person("Jane", "Doe", 25, Gender.WOMENS), TypeOfGolfer.BEGINNER, DominantHand.LEFT);
    }

    @Test
    public void testGolferInitialization() {
        assertEquals("Advanced male golfer should have a driver distance of 210", 210, maleGolfer.clubdistances.driver);
        assertEquals("Beginner female golfer should have a driver distance adjusted for female", 180, femaleGolfer.clubdistances.driver);
    }

    @Test
    public void testRecommendClub() {
        // Test under normal conditions
        assertEquals("Should recommend Driver for long distance", "3 Hybrid", maleGolfer.recommendClub(209, TypeOfCondition.CLEAR));
        assertEquals("Should recommend Driver for long distance", "8 iron", femaleGolfer.recommendClub(111, TypeOfCondition.CLEAR));
        // Test under adverse conditions which adds 10 yards to the distance requirement
        assertEquals("Should recommend Driver under windy conditions", "Driver", maleGolfer.recommendClub(209, TypeOfCondition.WINDY));
        assertEquals("Should recommend Driver for long distance", "7 iron", femaleGolfer.recommendClub(111, TypeOfCondition.RAINY));
    }

    @Test
    public void testToString() {
        assertTrue("toString should contain skill level and gender-specific club usage",
                maleGolfer.toString().contains("Advanced") && maleGolfer.toString().contains("Men's"));
    }
}