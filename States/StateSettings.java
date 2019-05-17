/*
 * Copyright by Luca Keller
 */

package States;

import MiscMain.*;
import Panels.*;

public class StateSettings extends State
{
  private PanelSettings panelSettings;


  public StateSettings(Game game){super(game);}

  @Override
  public void stateOn()
  {
    if(panelSettings == null)
      panelSettings = new PanelSettings(game);

    panelSettings.setVisible(true);
    game.getFrame().add(panelSettings);
  }

  @Override
  public void stateOff()
  {
    panelSettings.setVisible(false);
    game.getFrame().remove(panelSettings);

  }

  @Override
  public void update()
  {
    panelSettings.update();

    if (panelSettings.getBack() == true)
    {
      game.getGSM().setState(GameStateManager.STATE_MENUE);
      panelSettings.setBack(false);
    }
  }

  @Override
  public void render()
  {
    panelSettings.render();
  }
}


