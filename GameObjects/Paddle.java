/*
 * Copyright by Luca Keller
 */

package GameObjects;

import MiscMain.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends Sprite
{

  private boolean left = false;
  private boolean right = false;

  private int speed = 7;

  public Paddle(int x, int y, int width, int height)
  {
    super(x, y, width, height);
  }

  @Override
  public void draw(Graphics g)
  {
    g.fillRect(x, y, width, height);
  }

  @Override
  public void checkColission()//TODO
  {

  }

  @Override
  public void move()
  {

  }

  @Override
  public void updatePosition() //TODO
  {
    if (x + width <= Game.GAME_HEIGHT_WIDTH && x >= 0) {

    }

  }


  }

  public void setLeft(boolean left)
  {
    this.left = left;
  }

  public void setRight(boolean right)
  {
    this.right = right;
  }
}
