package com.example.phonecaddy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
    private Person person1;
    private Person person2;

    @Before
    public void setUp() {
        // Initialize two different Person instances
        person1 = new Person("John", "Doe", 35, Gender.MENS);
        person2 = new Person("Jane", "Smith", 28, Gender.WOMENS);
    }

    @Test
    public void testGetFirstName() {
        assertEquals("Checking first name of person1", "John", person1.getFirstName());
        assertEquals("Checking first name of person2", "Jane", person2.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Checking last name of person1", "Doe", person1.getLastName());
        assertEquals("Checking last name of person2", "Smith", person2.getLastName());
    }

    @Test
    public void testGetAge() {
        assertEquals("Checking age of person1", 35, person1.getYearOfBirth());
        assertEquals("Checking age of person2", 28, person2.getYearOfBirth());
    }

    @Test
    public void testGetGender() {
        assertEquals("Checking gender of person1", Gender.MENS, person1.getGender());
        assertEquals("Checking gender of person2", Gender.WOMENS, person2.getGender());
    }

    @Test
    public void testGetFullName() {
        assertEquals("Checking full name of person1", "John Doe", person1.getFullName());
        assertEquals("Checking full name of person2", "Jane Smith", person2.getFullName());
    }
}