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
  protected int score = 0;
  protected boolean left = false;
  protected boolean right = false;

  protected int speed = 7;

  protected Ball ball;

  public Paddle(int x, int y, int width, int height)
  {
    super(x, y, width, height);
  }

  @Override
  public void draw(Graphics g)
  {
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(x, y, width, height);
  }

  @Override
  public void move()
  {

    x += vx;
  }

  @Override
  public void start()
  {
    x = Game.GAME_HEIGHT_WIDTH / 2 - width / 2;
  }

  @Override
  public void updatePosition() //TODO vereinfachen
  {

    if (vx < 0) {
      if (x <= 0) {
        vx = 0;
      } else if (x + vx < 0) {
        vx = 0 - x;
      }

    }
    if (vx > 0) {
      if (x + width >= Game.GAME_HEIGHT_WIDTH) {
        vx = 0;
      } else if (x + width + vx >= Game.GAME_HEIGHT_WIDTH) {
        vx = Game.GAME_HEIGHT_WIDTH - (x + width);
      }

    }

    if (left == true) {
      vx = -speed;

    } else if (right == true) {
      vx = speed;
    }

  }

  public void setScore(int score) {this.score = score;}

  public int getScore() { return score; }

  public void incrementScore(){score++;}

  public void setLeft(boolean left)
  {
    this.left = left;
  }

  public void setRight(boolean right)
  {
    this.right = right;
  }

  public void setBall(Ball b)
  {
    this.ball = b;
  }

}
