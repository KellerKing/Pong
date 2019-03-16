import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends Sprite implements KeyListener
{

  public Paddle(int x, int y, int width, int height)
  {
    super(x, y, width, height);
    // TODO Auto-generated constructor stub
  }

  private boolean left = false, right = false;

  private int speed = 7;

  @Override
  public void updatePosition()
  {
    super.updatePosition();
  }

  public void move()
  {
    vx = 0;
    vy = 0;

    if (right == true)
    {
      vx = speed;
    }
    if (left == true)
    {
      vx = -speed;
    }
  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_A)
    {
      left = true;
      System.out.println("adx");

    } else if (e.getKeyCode() == KeyEvent.VK_D)
    {
      right = true;
    }

  }

  @Override
  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_A)
    {
      left = false;
    } else if (e.getKeyCode() == KeyEvent.VK_D)
    {
      right = false;
    }
  }

  @Override
  public void keyTyped(KeyEvent e)
  {

  }

}
