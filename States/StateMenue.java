/*
 * Copyright by Luca Keller
 */

package States;

import MiscMain.Game;
import Panels.PanelMenue;

public class StateMenue extends State
{
	private PanelMenue panelMenue;
	
	public StateMenue(Game game)
	{
		super(game);
	}

	@Override
	public void stateOn()
	{
		if (panelMenue == null)
			panelMenue = new PanelMenue();

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
		else if(panelMenue.getConfig() == true)
		{
			game.getGSM().setState(GameStateManager.STATE_SETTINGS);
		}
		else if(panelMenue.getStoppen() == true && panelMenue.getStarten() == false)
		{
			game.leuft = false;
		}
		panelMenue.resetBoolean();
	}

	public void render()
	{
		panelMenue.render();
	}


}
