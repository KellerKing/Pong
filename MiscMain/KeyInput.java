/*
 * Copyright by Luca Keller
 */

package MiscMain;
import GameObjects.Paddle;
import States.GameStateManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
  public KeyInput(Game game)
  {
    this.game = game;
    player1 = this.game.getPlayer1();
    player2 = this.game.getPlayer2();
    gsm = this.game.getGSM();
  }

  private Game game;
  private Paddle player1;
  private Paddle player2;
  private GameStateManager gsm;

  private static boolean player1Left = false;
  private static boolean player1Right = false;
  private static boolean player2Left = false;
  private static boolean player2Right = false;

  @Override
  public void keyPressed(KeyEvent e) //FIXME Hier ka wie es weiter gehen soll das Zentrale Keyboard Klasse die Methoden richtig aufruft. (OOP)
  {
      gsm.getState().keyPressed(e);
  }

  @Override
  public void keyReleased(KeyEvent e)
  {
    gsm.getState().keyReleased(e);
  }
}
