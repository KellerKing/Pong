
public class Ball
{
	private int posX;
	private int posY;
	private int velX = 0;
	private int velY = 0;
	
	private final double DURCHMESSER = 15;
	private final int SPEEDDOWN = 5;
	private final int SPEEDLEFT = 8;
	
	public Ball(int posX, int posY)
	{
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
	
	public boolean checkPaddleColsion()
	{
		return true;
	}
	
	public void checkBorderColission()
	{
		//TODO Fehleranfällig wenn x bei 0 ist und gerade abprallen will, dann wieder geprüft wird, und sich dann wieder auf 0 bewegt
		//Integer nicht genau genug
		if(posX >= -1 || posX <= Game.WIDTH - DURCHMESSER)
		{
			velX = -velX;
		}
		if(posY >= -1 || posY <= Game.HEIGHT - DURCHMESSER)
		{
			velY = -velY;
		}
		
	}
	public void updatePos()
	{
		if(checkPaddleColsion() == false)
		{
			checkBorderColission();
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
