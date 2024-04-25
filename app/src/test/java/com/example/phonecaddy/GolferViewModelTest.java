package com.example.phonecaddy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * This class contains all the unit test for the ViewModel of Pocket Caddy
 */
public class GolferViewModelTest {
    private GolferViewModel testmodel;
    @Before
    public void setUp() throws Exception {
        testmodel = new GolferViewModel();
    }

    /**
     * Tests whether getFirstName() gets the first name correctly
     */
    @Test
    public void getFirstName() {
        testmodel.setFirstName("Ben");
        assertEquals(testmodel.getFirstName(), "Ben");
        testmodel.setFirstName("Rock");
        assertEquals(testmodel.getFirstName(), "Rock");
    }

    /**
     * Tests whether setFirstName() sets the first name correctly
     */
    @Test
    public void setFirstName() {
        testmodel.setFirstName("Fish");
        assertEquals(testmodel.getFirstName(), "Fish");
        testmodel.setFirstName("Mike");
        assertEquals(testmodel.getFirstName(), "Mike");
    }

    /**
     * Tests whether getLastName() gets the last name correctly
     */
    @Test
    public void getLastName() {
        testmodel.setLastName("Ben");
        assertEquals(testmodel.getLastName(), "Ben");
        testmodel.setLastName("Rock");
        assertEquals(testmodel.getLastName(), "Rock");
    }

    /**
     * Tests whether setLastName() sets the last name correctly
     */
    @Test
    public void setLastName() {
        testmodel.setLastName("Fish");
        assertEquals(testmodel.getLastName(), "Fish");
        testmodel.setLastName("Mike");
        assertEquals(testmodel.getLastName(), "Mike");
    }

    /**
     * Tests whether getAge() gets the age correctly
     */
    @Test
    public void getAge() {
        testmodel.setAge(24);
        assertEquals(testmodel.getAge(), 24);
        testmodel.setAge(25);
        assertEquals(testmodel.getAge(), 25);
    }

    /**
     * Tests whether setAge() sets the age correctly
     */
    @Test
    public void setAge() {
        testmodel.setAge(26);
        assertEquals(testmodel.getAge(), 26);
        testmodel.setAge(27);
        assertEquals(testmodel.getAge(), 27);
    }

    /**
     * Tests whether getGender() gets the gender correctly
     */
    @Test
    public void getGender() {
        testmodel.setGender("MENS");
        assertEquals(testmodel.getGender(), "MENS");
        testmodel.setGender("WOMENS");
        assertEquals(testmodel.getGender(), "WOMENS");
    }

    /**
     * Tests whether setGender() sets the gender correctly
     */
    @Test
    public void setGender() {
        testmodel.setGender("MENS");
        assertEquals(testmodel.getGender(), "MENS");
        testmodel.setGender("WOMENS");
        assertEquals(testmodel.getGender(), "WOMENS");
    }

    /**
     * Tests whether getExperience() gets the experience level correctly
     */
    @Test
    public void getExperienceLevel() {
        testmodel.setExperienceLevel("BEGINNER");
        assertEquals(testmodel.getExperienceLevel(), "BEGINNER");
        testmodel.setExperienceLevel("AMATEUR");
        assertEquals(testmodel.getExperienceLevel(), "AMATEUR");
    }

    /**
     * Tests whether setExperienceLevel() sets the experience level correctly
     */
    @Test
    public void setExperienceLevel() {
        testmodel.setExperienceLevel("ADVANCED");
        assertEquals(testmodel.getExperienceLevel(), "ADVANCED");
        testmodel.setExperienceLevel("PRO");
        assertEquals(testmodel.getExperienceLevel(), "PRO");
    }

    /**
     * Tests whether getDominantHand() gets the dominant hand correctly
     */
    @Test
    public void getDominantHand() {
        testmodel.setDominantHand("RIGHT");
        assertEquals(testmodel.getDominantHand(), "RIGHT");
        testmodel.setDominantHand("LEFT");
        assertEquals(testmodel.getDominantHand(), "LEFT");
    }

    /**
     * Tests whether setDominantHand() sets the dominant hand correctly
     */
    @Test
    public void setDominantHand() {
        testmodel.setDominantHand("RIGHT");
        assertEquals(testmodel.getDominantHand(), "RIGHT");
        testmodel.setDominantHand("LEFT");
        assertEquals(testmodel.getDominantHand(), "LEFT");
    }

    /**
     * Tests whether getDistance() gets the distance correctly
     */
    @Test
    public void getDistance() {
        testmodel.setDistance(90);
        assertEquals(testmodel.getDistance(), 90);
        testmodel.setDistance(100);
        assertEquals(testmodel.getDistance(), 100);
    }

    /**
     * Tests whether setDistance() sets the distance correctly
     */
    @Test
    public void setDistance() {
        testmodel.setDistance(110);
        assertEquals(testmodel.getDistance(), 110);
        testmodel.setDistance(120);
        assertEquals(testmodel.getDistance(), 120);
    }

    /**
     * Tests whether getWeatherCondition() gets the weather condition correctly
     */
    @Test
    public void getWeatherCondition() {
        testmodel.setWeatherCondition("RAINY");
        assertEquals(testmodel.getWeatherCondition(), "RAINY");
        testmodel.setWeatherCondition("WINDY");
        assertEquals(testmodel.getWeatherCondition(), "WINDY");
    }

    /**
     * Tests whether setWeatherCondition() sets the weather condition correctly
     */
    @Test
    public void setWeatherCondition() {
        testmodel.setWeatherCondition("CLEAR");
        assertEquals(testmodel.getWeatherCondition(), "CLEAR");
        testmodel.setWeatherCondition("WINDY");
        assertEquals(testmodel.getWeatherCondition(), "WINDY");
    }
}