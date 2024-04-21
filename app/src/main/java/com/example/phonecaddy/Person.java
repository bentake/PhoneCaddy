package com.example.phonecaddy;

/**
 * This class represents a person with a first name, last name and a
 * year of birth
 */
public class Person {
  private String firstName;
  private String lastName;
  private int age;
  private Gender gender;
  /**
   * Constructs a Person object and initializes it to the given first name, last
   * name and year of birth
   *
   * @param firstName the first name of this person
   * @param lastName the last name of this person
   * @param age the year of birth of this person
   */
  public Person(String firstName, String lastName, int age, Gender gender) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
  }
  /**
   * Get the first name of this person
   *
   * @return the first name of this person
   */
  public String getFirstName() {
    return this.firstName;
  }
  /**
   * Return the last name of this person
   *
   * @return the last name of this person
   */
  public String getLastName() {
    return this.lastName;
  }
  /**
   * Return the age of this person
   *
   * @return the age of this person
   */
  public int getYearOfBirth() {
    return this.age;
  }

  /**
   * Return the gender of this person
   *
   * @return the gender of this person
   */
  public Gender getGender() {
    return this.gender;
  }

  /**
   * Return the full name of this person
   *
   * @return the full name of this person
   */
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }
}
