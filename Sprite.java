import java.awt.*;
import java.awt.event.KeyListener;

public abstract class Sprite implements KeyListener
{
  protected int x;
  protected int y;
  protected int vx;
  protected int vy;
  protected int width;
  protected int height;

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
  {
    x += vx;
    y += vy;
  }

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

}
