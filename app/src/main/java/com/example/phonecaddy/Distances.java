package com.example.phonecaddy;

/**
 * Represents a set of golf club distances differentiated by player skill level and gender.
 * This class provides functionality to update golf club distances based on the skill level
 * and apply modifications specific to female players.
 */
public class Distances {

  protected int pw;
  protected int sw;
  protected int iron9;
  protected int iron8;
  protected int iron7;
  protected int iron6;
  protected int iron5;
  protected int iron4;
  protected int wood4;
  protected int hybrid3;
  protected int driver;
  protected Gender gender;
  private Boolean beenChanged;

  /**
   * Constructs a new distance object with initial distances set according to a beginner level.
   * The gender is set based on the input parameter, initializing the change status to false.
   *
   * @param gender the gender of the player, used to adjust distances if necessary
   */
  public Distances(Gender gender){
    this.sw = 90;
    this.pw = 100;
    this.iron9 = 110;
    this.iron8 = 120;
    this.iron7 = 130;
    this.iron6 = 140;
    this.iron5 = 150;
    this.iron4 = 160;
    this.wood4 = 170;
    this.hybrid3 = 180;
    this.driver = 190;

    this.gender = gender;
    this.beenChanged = Boolean.FALSE;
  }

  /**
   * Updates the distances to intermediate level.
   */
  void becomeIntermediate(){
    this.sw = 100;
    this.pw = 110;
    this.iron9 = 120;
    this.iron8 = 130;
    this.iron7 = 140;
    this.iron6 = 150;
    this.iron5 = 160;
    this.iron4 = 170;
    this.wood4 = 180;
    this.hybrid3 = 190;
    this.driver = 200;
  }

  /**
   * Updates the distances to advanced level.
   */
  void becomeAdvanced(){
    this.sw = 110;
    this.pw = 120;
    this.iron9 = 130;
    this.iron8 = 140;
    this.iron7 = 150;
    this.iron6 = 160;
    this.iron5 = 170;
    this.iron4 = 180;
    this.wood4 = 190;
    this.hybrid3 = 200;
    this.driver = 210;
  }

  /**
   * Updates the distances to Amateur level.
   */
  void becomeAmateur(){
    this.sw = 120;
    this.pw = 130;
    this.iron9 = 140;
    this.iron8 = 150;
    this.iron7 = 160;
    this.iron6 = 170;
    this.iron5 = 180;
    this.iron4 = 190;
    this.wood4 = 200;
    this.hybrid3 = 210;
    this.driver = 220;
  }

  /**
   * Updates the distances to Professional level.
   */
  void becomePro(){
    this.sw = 130;
    this.pw = 140;
    this.iron9 = 150;
    this.iron8 = 160;
    this.iron7 = 170;
    this.iron6 = 180;
    this.iron5 = 190;
    this.iron4 = 200;
    this.wood4 = 210;
    this.hybrid3 = 220;
    this.driver = 230;
  }

  /**
   * Resets the distances back to beginner level.
   */
  void resetToBeginner(){
    this.sw = 90;
    this.pw = 100;
    this.iron9 = 110;
    this.iron8 = 120;
    this.iron7 = 130;
    this.iron6 = 140;
    this.iron5 = 150;
    this.iron4 = 160;
    this.wood4 = 170;
    this.hybrid3 = 180;
    this.driver = 190;
  }

  /**
   * Adjusts distances down by 10 for each club if the player is female and the distances have
   * not yet been changed.
   */
  void changeToFemale(){
    if (gender == Gender.WOMENS && this.beenChanged == Boolean.FALSE){
      beenChanged = Boolean.TRUE;
      this.sw = this.sw - 10;
      this.pw = this.pw - 10;
      this.iron9 = this.iron9 - 10;
      this.iron8 = this.iron8 - 10;
      this.iron7 = this.iron7 - 10;
      this.iron6 = this.iron6 - 10;
      this.iron5 = this.iron5 - 10;
      this.iron4 = this.iron4 - 10;
      this.wood4 = this.wood4 - 10;
      this.hybrid3 = this.hybrid3 - 10;
      this.driver = this.driver - 10;
    }
  }

  /**
   * Gets the current state of BeenChanged
   *
   * @return Boolean representing if the Gender had been changed before
   */
  public Boolean getBeenChanged() {
    return beenChanged;
  }

  /**
   * Provides a string representation of current club distances.
   *
   * @return a formatted string listing distances for each club
   */
  @Override
  public String toString(){
    String str;
    str = "Your current distances:\n" +
        "Sand Wedge:" + this.sw + "\n" +
        "Pitching Wedge:" + this.pw + "\n" +
        "9 Iron:" + this.iron9 + "\n" +
        "8 Iron:" + this.iron8 + "\n" +
        "7 Iron:" + this.iron7 + "\n" +
        "6 Iron:" + this.iron6 + "\n" +
        "5 Iron:" + this.iron5 + "\n" +
        "4 Iron:" + this.iron4 + "\n" +
        "4 Wood:" + this.wood4 + "\n" +
        "4 Hybrid:" + this.hybrid3 + "\n" +
        "Driver:" + this.driver;

    return str;
  }


}
