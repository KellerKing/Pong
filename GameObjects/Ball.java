/*
 * Copyright by Luca Keller
 */

package GameObjects;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Ball extends Sprite
{
	private int speed = 10;

	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void draw(Graphics g)
	{
		g.fillOval(x,y,width,height);
	}

	@Override
	public void checkColission()
	{

	}

}
