/*
 * Copyright by Luca Keller
 */

package States;

import MiscMain.Game;
import Panels.PanelGame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StateGame extends State
{
	private PanelGame panelGame;
	
	public StateGame(Game game)
	{
		super(game);

	}

	@Override
	public void stateOn()
	{
		if(panelGame == null)
			panelGame = new PanelGame(game);

		game.getFrame().add(panelGame);
		panelGame.requestFocus();
		panelGame.setVisible(true);
	}

	@Override
	public void stateOff()
	{
		panelGame.setVisible(false);
		game.getFrame().remove(panelGame);
	}

	@Override
	public void update()
	{
		panelGame.update();
	}

	@Override
	public void render()
	{
		panelGame.render();
	}


}
