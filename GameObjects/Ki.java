/*
 * Copyright by Luca Keller
 */

package GameObjects;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Ki extends Paddle
{

  public Ki(int x, int y, int width, int height)
  {
    super(x, y, width, height);
  }

  @Override
  public void draw(Graphics g)
  {
    g.fillRect(x,y,width,height);
  }
}
