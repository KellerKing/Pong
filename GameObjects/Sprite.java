/*
 * Copyright by Luca Keller
 */

package GameObjects;

import MiscMain.Game;

import java.awt.*;
import java.awt.event.KeyListener;

public abstract class Sprite
{
  protected int x;
  protected int y;
  protected int vx;
  protected int vy;
  protected int width;
  protected int height;
  protected int speed;

  public Sprite(int x, int y, int width, int height)
  {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public Rectangle getBounds()
  {
    return new Rectangle(x, y, height, height);
  }

  public void updatePosition()
  {}

  public void updatePosition(int direction){}

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }

  public int getHeight()
  {
    return height;
  }

  public int getWidth()
  {
    return width;
  }

  public abstract void draw(Graphics g);

  public void move()
  {
    x += (vx * speed);
    y += (vy * speed);
  }

  public void start()
  {
    this.x = Game.GAME_HEIGHT_WIDTH / 2 - this.width / 2;
  }


}
