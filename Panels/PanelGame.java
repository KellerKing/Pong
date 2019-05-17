/*
 * Copyright by Luca Keller
 */

package Panels;

import GameObjects.Ball;
import GameObjects.Paddle;
import MiscMain.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class PanelGame extends JPanel implements KeyListener
{

  private Paddle[] player = new Paddle[2];

  private Ball ball;

  private Game game;

  private Timer timer;

  private long timerSek = 3;

  public PanelGame(Game game)
  {
    this.game = game;
    ball = game.getBall();

    player[0] = game.getPlayer1();
    player[1] = game.getPlayer2();

    player[0].setBall(ball);
    player[1].setBall(ball);

    timer = new Timer(); //TODO


    initPanelGame();
  }

  public void initPanelGame()
  {

    this.setSize(Game.GAME_HEIGHT_WIDTH, Game.GAME_HEIGHT_WIDTH);
    this.setLayout(null);

    this.addKeyListener(this);
  }

  public void render()
  {
    this.repaint();
  }

  public void update()
  {
    int direction = 0; // Richtung die der Ball sich bewegen soll

    //Wenn ein Punkt gemacht wird
    for(int i = 0; i < player.length; i++)
    {
      if(ball.loosePlayer(player[i]))
      {
        player[i].incrementScore();
        player[0].start();
        player[1].start();
        ball.start();
        repaint();

        //Delay 3 Seconds
        try {
          TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }

    if (ball.checkBorderColission() == true)
    {
      direction = 3;
    }

     else if (ball.checkPaddleColission(player[0]) == true) //Unterer Player
    {

      direction = 1;
    }

     else if (ball.checkPaddleColission(player[1]) == true) // Oberer Player
    {
      direction = 2;
    }


    player[0].updatePosition();
    player[1].updatePosition();
    ball.updatePosition(direction);
    player[0].move();
    player[1].move();
    ball.move();

  }

  @Override
  public void paint(Graphics g)
  {
    super.paint(g);
    player[0].draw(g);
    player[0].drawScore(g); //TODO
    player[1].drawScore(g);
    player[1].draw(g);
    ball.draw(g);
  }

  @Override
  public void keyTyped(KeyEvent keyEvent)
  {

  }

  @Override
  public void keyPressed(KeyEvent keyEvent)
  {
    if (keyEvent.getKeyCode() == KeyEvent.VK_A) {
      player[0].setLeft(true);
    } else if (keyEvent.getKeyCode() == KeyEvent.VK_D) {
      player[0].setRight(true);
    } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT && player[1] instanceof Paddle) {
      player[1].setLeft(true);
    } else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT && player[1] instanceof Paddle) {
      player[1].setRight(true);
    }
  }

  @Override
  public void keyReleased(KeyEvent keyEvent)
  {
    if (keyEvent.getKeyCode() == KeyEvent.VK_A) {
      player[0].setLeft(false);
    } else if (keyEvent.getKeyCode() == KeyEvent.VK_D) {
      player[0].setRight(false);
    } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT && player[1] instanceof Paddle) {
      player[1].setLeft(false);
    } else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT && player[1] instanceof Paddle) {
      player[1].setRight(false);
    }
  }
}