package com.example.phonecaddy;

import androidx.lifecycle.ViewModel;

/**
 * Represents GolferViewModel class which is a ViewModel class, which stores and manages data
 * gathered from the user interface throughout the entire fragment that the user interacts with.
 */
public class GolferViewModel extends ViewModel {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String experienceLevel;
    private String dominantHand;
    private int distance;
    private String weatherCondition;

    /**
     * Gets the first name of the user
     * @return the first name of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user
     * @param firstName the first naem of the user that is to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user
     * @return last name of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user
     * @param lastName last name of the user to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the age of the user
     * @return the age of the user
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the user
     * @param age the age of the user to be set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the gender of the user
     * @return the gender of the user
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the user
     * @param gender the gender of the user to be set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the experience level of the user
     * @return the experience level of the user
     */
    public String getExperienceLevel() {
        return experienceLevel;
    }

    /**
     * Sets the experience level of the user
     * @param experienceLevel the experience level of the user to be set
     */
    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    /**
     * Gets the dominant hand of the user
     * @return dominant hand of the user
     */
    public String getDominantHand() {
        return dominantHand;
    }

    /**
     * Sets the dominant hand of the user
     * @param dominantHand dominant hand of the user to be set
     */
    public void setDominantHand(String dominantHand) {
        this.dominantHand = dominantHand;
    }

    /**
     * Gets the distance for the swing of the user
     * @return distance fot the swing of the user
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Sets the distance for the swing of the user
     * @param distance distance for the swing of the user to be set
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Gets the weather condition for the swing
     * @return the weather condition for the swing
     */
    public String getWeatherCondition() {
        return weatherCondition;
    }

    /**
     * Sets the weather condition for the swing
     * @param weatherCondition the weather condition for the swing to be set
     */
    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }
}
