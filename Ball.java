import java.awt.Rectangle;
import java.time.chrono.MinguoChronology;
import java.lang.Math.*;

public class Ball
{
	private int posX;
	private int posY;
	private int velX = 0;
	private int velY = 0;
	
	private final double DURCHMESSER = 15;
	private final int SPEEDDOWN = 5;
	private final int SPEEDLEFT = 8;
	
	private Paddle paddleLeft;
	private Paddle paddleRight;
	
	public Ball(int posX, int posY, Paddle paddle1, Paddle paddle2)
	{
		this.paddleLeft = paddle1;
		this.paddleRight = paddle2;
		
		this.posX = posX;
		this.posY = posY;
		start();
	}
	
	public void start()
	{
		switch ((int) ( Math.random() * 4 + 1))
		{
		case 1:
			velX = SPEEDLEFT;
			velY = SPEEDDOWN;
			break;
		case 2:
			velX = -SPEEDLEFT;
			velY = SPEEDDOWN;
			break;
		case 3:
			velX = SPEEDLEFT;
			velY = -SPEEDDOWN;
			break;
		case 4:
			velX = -SPEEDLEFT;
			velY = -SPEEDDOWN;
			break;
		default:
			break;
		}
		
	}
	
	public boolean checkPaddleColssion()
	{
		checkPaddleColissionLeft();
		
		return true;
	}
	//TODO intersect with Paddle
	public boolean checkPaddleColissionLeft()
	{
		int deltaX = posX - Math.max(paddleLeft.getX(), Math.min(posX, paddleLeft.getX() + paddleLeft.getWIDTH_PADDLE()));
		int deltaY = posY - Math.max(paddleLeft.getY(), Math.min(posY, paddleLeft.getY() + paddleLeft.getHEIGHT_PADDLE()));
		
		if((deltaX * deltaX + deltaY * deltaY) < (DURCHMESSER / 2 * DURCHMESSER / 2))
		{
			return true;
		}
		return false;
	}
	
	public boolean checkPaddleColissionRight()
	{
		int deltaX = posX - Math.max(paddleRight.getX(), Math.min(posX, paddleRight.getX() + paddleRight.getWIDTH_PADDLE()));
		int deltaY = posY - Math.max(paddleRight.getY(), Math.min(posY, paddleRight.getY() + paddleRight.getHEIGHT_PADDLE()));
		
		if((deltaX * deltaX + deltaY * deltaY) < (DURCHMESSER / 2 * DURCHMESSER / 2))
		{
			return true;
		}
		return false;
	}
	
	public boolean checkBorderColission()
	{
		//TODO Fehleranfällig wenn x bei 0 ist und gerade abprallen will, dann wieder geprüft wird, und sich dann wieder auf 0 bewegt
		//Integer nicht genau genug
		if(posX >= -1 || posX <= Game.WIDTH_FRAME - DURCHMESSER)
		{
			velX = -velX;
		}
		if(posY >= -1 || posY <= Game.HEIGHT_FRAME - DURCHMESSER)
		{
			velY = -velY;
		}
		
		return false;
		
	}
	public void updatePos()
	{
		if(checkPaddleColissionLeft() == true || checkPaddleColissionRight() == true)
		{
			velX = -velX;
			velY = -velY;
		}
		else if (checkBorderColission() == true)
		{
			
		}
		
		posX += velX;
		posY += velY;
		
		
		
	}
	
	public int getX()
	{
		return posX;
	}
	public int getY()
	{
		return posY;
	}
	
}
