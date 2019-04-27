/*
 * Copyright by Luca Keller
 */

package States;

import MiscMain.Game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public abstract class State
{
	protected Game game;

	public State(Game game)
	{
		this.game = game;
	}
	
	public abstract void stateOn();
	public abstract void stateOff();
	public abstract void update();
	public abstract void render();
	
}
