/*
 * Copyright by Luca Keller
 */

package Panels;

import GameObjects.Ball;
import GameObjects.Paddle;
import MiscMain.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PanelGame extends JPanel implements KeyListener
{
  private Paddle player1;
  private Paddle player2;
  private Ball ball;

  private Game game;

  public PanelGame(Game game)
  {
    this.game = game;
    player1 = game.getPlayer1();
    player2 = game.getPlayer2();
    ball = game.getBall();

    this.setSize(Game.GAME_HEIGHT_WIDTH, Game.GAME_HEIGHT_WIDTH);
    this.setLayout(null);

    initPanelGame();
  }

  public void initPanelGame()
  {

  }

  public void render()
  {
    this.revalidate();
    this.repaint();
  }

  public void update()
  {
    player1.move();
    player1.updatePosition();
  }

  @Override
  public void paint(Graphics g)
  {
    g.clearRect(0,0, Game.GAME_HEIGHT_WIDTH, Game.GAME_HEIGHT_WIDTH);
    player1.draw(g);
    player2.draw(g);
    ball.draw(g);
    System.out.println("Hier");
  }

  @Override
  public void keyTyped(KeyEvent keyEvent)
  {

  }

  @Override
  public void keyPressed(KeyEvent keyEvent)
  {
    if (keyEvent.getKeyCode() == KeyEvent.VK_A)
    {
      player1.setLeft(true);
    }
    else if (keyEvent.getKeyCode() == KeyEvent.VK_D)
    {
      player1.setRight(true);
    }
    else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT && player2 instanceof Paddle)
    {
      player2.setLeft(true);
    }
    else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT && player2 instanceof Paddle)
    {
      player2.setRight(true);
    }
  }

  @Override
  public void keyReleased(KeyEvent keyEvent)
  {
    if (keyEvent.getKeyCode() == KeyEvent.VK_A)
    {
      player1.setLeft(false);
    }
    else if (keyEvent.getKeyCode() == KeyEvent.VK_D)
    {
      player1.setRight(false);
    }
    else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT && player2 instanceof Paddle)
    {
      player2.setLeft(false);
    }
    else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT && player2 instanceof Paddle)
    {
      player2.setRight(false);
    }
  }
}