import java.awt.Rectangle;

public class Paddle
{
	private int x;
	private int y;

	private final int SPEED = 3;
	private final int WIDTH_PADDLE = Game.WIDTH_FRAME / 15;
	private final int HEIGHT_PADDLE = Game.HEIGHT_FRAME / 10;

	public Paddle(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void updatePosition()
	{
	}

	public Rectangle getBounds()
	{
		return new Rectangle(x, y, WIDTH_PADDLE, HEIGHT_PADDLE);
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public int getWIDTH_PADDLE()
	{
		return WIDTH_PADDLE;
	}
	public int getHEIGHT_PADDLE()
	{
		return HEIGHT_PADDLE;
	}
	

}
