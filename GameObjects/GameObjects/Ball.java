/*
 * Copyright by Luca Keller
 */

package GameObjects;

import MiscMain.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ball extends Sprite
{
  private int treffer = 0;
  private int speed = 3;
  private double angle;

  Random r = new Random();

  public Ball(int x, int y, int width, int height)
  {
    super(x, y, width, height);
    start();
  }

  @Override
  public void updatePosition(int direction)
  {
    switch (direction) {
      case 1:
        vx = -(treffer / 2);
        vy = -(treffer / 2);
        break;

      case 2:
        vx = (treffer / 2);
        vy = (treffer / 2);
        break;
    }
    if (direction == 3) {
      vx = -vx;
    }

  }

  @Override
  public void draw(Graphics g)
  {
    g.setColor(Color.GREEN);
    g.fillOval(x, y, width, height);
  }


  public boolean loosePlayer(Paddle a) //TODO kann vereinfacht werden.
  {
    if (a.getY() > Game.GAME_HEIGHT_WIDTH / 2) // Unterer Spieler
    {
      if(y + width >= Game.GAME_HEIGHT_WIDTH)
      {

       return true;
      }

      else
      {

        return false;
      }
    }
    else if(a.getY() < Game.GAME_HEIGHT_WIDTH / 2) // Oberer Spieler
    {
      if( y <= 0)
      {

        return true;
      }

      else
      {

        return false;
      }
    }

    return false;
  }

  public boolean checkPaddleColission(Paddle a)
  {
    if (x < a.getX() + a.getWidth() && x + width > a.getX() && y < a.getY() + a.getHeight() && y + height > a.getY()) {
      treffer++;
      return true;
    } else {
      return false;
    }
  }

  public boolean checkBorderColission()
  {
    if (x + width > Game.GAME_HEIGHT_WIDTH || x <= 0) {
      return true;
    } else {
      return false;
    }
  }


  @Override
  public void move() //TODO Teilweise zu langsam
  {
    x += (vx * speed);
    y += (vy * speed);
  }

  @Override
  public void start()
  {
    x = Game.GAME_HEIGHT_WIDTH / 2 - width / 2;
    y = Game.GAME_HEIGHT_WIDTH / 2 - height / 2;
    treffer = 0;

    //(max + 1 - min) + min ---> inclusve betweeen values
    vy = r.nextInt(2 + 1 + 2) - 2;
    if (vy == 0)
    {
      vy = 1;
    }

    //Delay 3 Seconds
    try {
      TimeUnit.SECONDS.sleep(3);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

}
