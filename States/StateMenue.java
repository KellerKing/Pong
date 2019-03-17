/*
 * Copyright by Luca Keller
 */

package States;

import java.awt.event.KeyEvent;
import MiscMain.*;
import Panels.*;

public class StateMenue extends State
{
	private PanelMenue panelMenue = new PanelMenue();
	
	public StateMenue(Game game)
	{
		super(game);
	}

	@Override
	public void stateOn()
	{
		panelMenue.setVisible(true);
		game.getFrame().add(panelMenue);
	}

	@Override
	public void stateOff()
	{
		panelMenue.setVisible(false);
		game.getFrame().remove(panelMenue);
	}

	@Override
	public void update()
	{
		panelMenue.update();
		
		if(panelMenue.getStarten() == true && panelMenue.getStoppen() == false)
		{
			game.getGSM().setState(GameStateManager.STATE_GAME);
		}
		else if(panelMenue.getStoppen() == true && panelMenue.getStarten() == false)
		{
			game.leuft = false;
		}
	}

	public void render()
	{
		panelMenue.render();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{

	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}

}
