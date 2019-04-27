/*
 * Copyright by Luca Keller
 */

package MiscMain;

public class Settings
{
  private static int difficulty;
  private static byte multiplayer;


  public static byte getMultiplayer()
  {
    return multiplayer;
  }

  public static void setMultiplayer(byte multiplayer)
  {
    Settings.multiplayer = multiplayer;
  }

  public static int getDifficulty()
  {
    return difficulty;
  }

  public static void setDifficulty(int difficulty)
  {
    Settings.difficulty = difficulty;
  }
}
