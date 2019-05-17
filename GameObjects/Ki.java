/*
 * Copyright by Luca Keller
 */

package GameObjects;

import MiscMain.Game;

import java.awt.*;

public class Ki extends Paddle
{
  private double speed = 7;
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
  public void updatePosition()
  {
    if(x > 0 && x + width < Game.GAME_HEIGHT_WIDTH)
    {
      if (ball.getY() <= Game.GAME_HEIGHT_WIDTH / 2) // Reagiert erst ab der Mitte
      {
        if (x > 0 && x + width < Game.GAME_HEIGHT_WIDTH) {
          if (ball.getX() > x && ball.getX() + ball.width < x + width) {

            vx = 0;

            //Ki Dont need to move
          }
          else if (ball.getX() < x) //Move Left
          {
            vx = (int) - speed;

          } else if (ball.getX() > x + width) //Move Right
          {
            vx = (int) speed;
          }

        }
      }
    } else  {
      if (x + width >= Game.GAME_HEIGHT_WIDTH)
      {
        vx = -1;
      }
      else if (x <= 0 )
      {
        vx = 1;
      }
      else
        {
        vx = 0;
      }
    }

  }
  @Override
  public void move() //TODO Superklasse verbessern
  {
    super.move();
  }

  @Override
  public void start()
  {
    super.start();
  }
}
