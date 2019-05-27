/*
 * Copyright by Luca Keller
 */

package MiscMain;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Countdown
{
  private int timerSek;
  private int countSek = -1; // Value because it dont get drawn when game first started

  private boolean paused = false;

  private Game game;

  public Countdown(int timerSek, Game game)
  {
    this.timerSek = timerSek;
    this.game = game;
  }

  public void timerNow() //Countdown timer
  {
    paused = true;

    countSek = timerSek;

    Timer timer = new Timer();

    TimerTask tTask = new TimerTask()
    {
      @Override
      public void run()
      {
        if(countSek > 0)
        {
          countSek--;
        }
        else
        {
          paused = false;
          countSek--;
          timer.cancel();
        }
      }
    };
    //Schedules the specified task for repeated fixed-delay execution, beginning after the specified delay.
    timer.schedule(tTask,0,1000);
  }
  public void draw(Graphics g) //Draw the Countdown
  {
    g.setColor(Color.RED);
    g.setFont(new Font("Arial", Font.BOLD,20));
    g.drawString(String.valueOf(countSek), Game.GAME_HEIGHT_WIDTH /2, Game.GAME_HEIGHT_WIDTH /2);
  }

  public int getCountSek()
  {
    return countSek;
  }

  public boolean isPaused()
  {
    return paused;
  }

  public void setPaused(boolean paused)
  {
    this.paused = paused;
  }

}
