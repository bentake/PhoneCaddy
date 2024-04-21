package com.example.phonecaddy;

/**
 * Represents a golfer with specific attributes including skill level, dominant hand,
 * personal information, and club distances adjusted for both skill level and gender.
 */
public class Golfer {

  protected Distances clubdistances;
  protected Person person;
  protected TypeOfGolfer skillLevel;
  protected DominantHand dominantHand;

  /**
   * Constructs a new golfer instance initializing the golfer's personal details,
   * skill level, and dominant hand. It sets up the golf club distances based on the
   * golfer's skill level and gender.
   *
   * @param person the personal details of the golfer, including gender
   * @param skillLevel the skill level of the golfer, used to adjust club distances
   * @param dominantHand the dominant hand of the golfer
   */
  public Golfer(Person person, TypeOfGolfer skillLevel,
                DominantHand dominantHand) {
    this.clubdistances = new Distances(person.getGender());
    this.person = person;
    this.skillLevel = skillLevel;
    this.dominantHand = dominantHand;

    switch (skillLevel) {
      case BEGINNER:
        this.clubdistances.resetToBeginner();
        break;
      case INTERMEDIATE:
        this.clubdistances.becomeIntermediate();
        break;
      case ADVANCED:
        this.clubdistances.becomeAdvanced();
        break;
      case AMATEUR:
        this.clubdistances.becomeAmateur();
        break;
      case PRO:
        this.clubdistances.becomePro();
        break;
    }

    if (person.getGender() == Gender.WOMENS) {clubdistances.changeToFemale();}
  }

  /**
   * Recommends the appropriate golf club to use based on the distance to the hole
   * and the current weather conditions. Adjustments are made to the distance in
   * adverse conditions.
   *
   * @param distance the distance from the golfer to the hole
   * @param condition the current weather condition affecting play
   * @return the recommended golf club to use for the shot
   */
  public String recommendClub(int distance, TypeOfCondition condition ){
    if (condition == TypeOfCondition.RAINY || condition == TypeOfCondition.WINDY){
      distance += 10;
    }
    String club;
    if (clubdistances.driver < distance){
      return "Driver";
    }else if (clubdistances.hybrid3 < distance){
      return "3 Hybrid";
    }else if (clubdistances.wood4 < distance){
      return "4 Wood";
    }else if (clubdistances.iron4 < distance){
      return "4 iron";
    }else if (clubdistances.iron5 < distance){
      return "5 iron";
    }else if (clubdistances.iron6 < distance){
      return "6 iron";
    }else if (clubdistances.iron7 < distance){
      return "7 iron";
    }else if (clubdistances.iron8 < distance){
      return "8 iron";
    }else if (clubdistances.iron9 < distance){
      return "9 iron";
    }else if (clubdistances.pw < distance){
      return "Pitching Wedge";
    }else {return "Sand Wedge";}
  }

  /**
   * Provides a string representation of the golfer, including skill level,
   * gender-specific club usage, and a list of club distances.
   *
   * @return a string summarizing the golfer's information and current club settings
   */
  @Override
  public String toString(){
    String skill = "";
    switch (skillLevel) {
      case BEGINNER:
        skill = "Beginner";
        break;
      case INTERMEDIATE:
        skill = "Intermediate";
        break;
      case ADVANCED:
        skill = "Advanced";
        break;
      case AMATEUR:
        skill = "Amateur";
        break;
      case PRO:
        skill = "Professional";
        break;
    }

    String clubsUsed = "";
    switch (person.getGender()) {
      case MENS:
        clubsUsed = "Men's";
        break;
      case WOMENS:
        clubsUsed = "Women's";
        break;
    }

    String str = "This is a " + clubsUsed + " " + skill +
        " level golfer. \n" + this.clubdistances.toString();

    return str;
  }

}
