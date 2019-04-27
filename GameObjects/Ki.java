/*
 * Copyright by Luca Keller
 */

package GameObjects;

import MiscMain.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

public class Ki extends Paddle
{
  private double speed = 3;
  private int durlauf = 0;

  public Ki(int x, int y, int width, int height)
  {
    super(x, y, width, height);
  }

  @Override
  public void draw(Graphics g)
  {
    super.draw(g);
  }

  @Override
  public void updatePosition() //TODO PRIO
  {
    if(durlauf %2 == 0) // Damit Ki etwas "dümmer" wird
    {
      if(ball.getY() <= Game.GAME_HEIGHT_WIDTH / 2)
      {
        if(ball.getX() + ball.width / 2 > this.x + this.width)
        {
          //Jetzt muss Paddle nach Rechts
          vx = (int)speed;
        }
        else if(ball.getX() < this.x - width /2)
        {
          //Jetzt Links
          vx = (int)-speed;
        }
      }
      durlauf++;

    }
    else
    {
      speed += 0.02;
      vx = 0;
      durlauf = 0;
    }

  }

  @Override
  public void move() //TODO Superklasse verbessern
  {

  }

  @Override
  public void start()
  {
    super.start();
  }
}
