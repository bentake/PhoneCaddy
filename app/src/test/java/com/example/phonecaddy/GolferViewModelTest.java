package com.example.phonecaddy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GolferViewModelTest {
    private GolferViewModel testmodel;
    @Before
    public void setUp() throws Exception {
        testmodel = new GolferViewModel();
    }

    @Test
    public void getFirstName() {
        testmodel.setFirstName("Ben");
        assertEquals(testmodel.getFirstName(), "Ben");
        testmodel.setFirstName("Rock");
        assertEquals(testmodel.getFirstName(), "Rock");
    }

    @Test
    public void setFirstName() {
        testmodel.setFirstName("Fish");
        assertEquals(testmodel.getFirstName(), "Fish");
        testmodel.setFirstName("Mike");
        assertEquals(testmodel.getFirstName(), "Mike");
    }

    @Test
    public void getLastName() {
        testmodel.setLastName("Ben");
        assertEquals(testmodel.getLastName(), "Ben");
        testmodel.setLastName("Rock");
        assertEquals(testmodel.getLastName(), "Rock");
    }

    @Test
    public void setLastName() {
        testmodel.setLastName("Fish");
        assertEquals(testmodel.getLastName(), "Fish");
        testmodel.setLastName("Mike");
        assertEquals(testmodel.getLastName(), "Mike");
    }

    @Test
    public void getAge() {
        testmodel.setAge(24);
        assertEquals(testmodel.getAge(), 24);
        testmodel.setAge(25);
        assertEquals(testmodel.getAge(), 25);
    }

    @Test
    public void setAge() {
        testmodel.setAge(26);
        assertEquals(testmodel.getAge(), 26);
        testmodel.setAge(27);
        assertEquals(testmodel.getAge(), 27);
    }

    @Test
    public void getGender() {
        testmodel.setGender("MENS");
        assertEquals(testmodel.getGender(), "MENS");
        testmodel.setGender("WOMENS");
        assertEquals(testmodel.getGender(), "WOMENS");
    }

    @Test
    public void setGender() {
        testmodel.setGender("MENS");
        assertEquals(testmodel.getGender(), "MENS");
        testmodel.setGender("WOMENS");
        assertEquals(testmodel.getGender(), "WOMENS");
    }

    @Test
    public void getExperienceLevel() {
        testmodel.setExperienceLevel("BEGINNER");
        assertEquals(testmodel.getExperienceLevel(), "BEGINNER");
        testmodel.setExperienceLevel("AMATEUR");
        assertEquals(testmodel.getExperienceLevel(), "AMATEUR");
    }

    @Test
    public void setExperienceLevel() {
        testmodel.setExperienceLevel("ADVANCED");
        assertEquals(testmodel.getExperienceLevel(), "ADVANCED");
        testmodel.setExperienceLevel("PRO");
        assertEquals(testmodel.getExperienceLevel(), "PRO");
    }

    @Test
    public void getDominantHand() {
        testmodel.setDominantHand("RIGHT");
        assertEquals(testmodel.getDominantHand(), "RIGHT");
        testmodel.setDominantHand("LEFT");
        assertEquals(testmodel.getDominantHand(), "LEFT");
    }

    @Test
    public void setDominantHand() {
        testmodel.setDominantHand("RIGHT");
        assertEquals(testmodel.getDominantHand(), "RIGHT");
        testmodel.setDominantHand("LEFT");
        assertEquals(testmodel.getDominantHand(), "LEFT");
    }

    @Test
    public void getDistance() {
        testmodel.setDistance(90);
        assertEquals(testmodel.getDistance(), 90);
        testmodel.setDistance(100);
        assertEquals(testmodel.getDistance(), 100);
    }

    @Test
    public void setDistance() {
        testmodel.setDistance(110);
        assertEquals(testmodel.getDistance(), 110);
        testmodel.setDistance(120);
        assertEquals(testmodel.getDistance(), 120);
    }

    @Test
    public void getWeatherCondition() {
        testmodel.setWeatherCondition("RAINY");
        assertEquals(testmodel.getWeatherCondition(), "RAINY");
        testmodel.setWeatherCondition("WINDY");
        assertEquals(testmodel.getWeatherCondition(), "WINDY");
    }

    @Test
    public void setWeatherCondition() {
        testmodel.setWeatherCondition("CLEAR");
        assertEquals(testmodel.getWeatherCondition(), "CLEAR");
        testmodel.setWeatherCondition("WINDY");
        assertEquals(testmodel.getWeatherCondition(), "WINDY");
    }
}