import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PanelGame extends JPanel
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
    this.addKeyListener(player1);
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
    g.clearRect(0,0,Game.GAME_HEIGHT_WIDTH, Game.GAME_HEIGHT_WIDTH);
    g.fillRect(player1.getX(), player1.getY(), player1.getWidth(), player1.getHeight()); //Player1 drawing
    g.fillRect(player2.getX(), player2.getY(), player2.getWidth(), player2.getHeight()); //Player2 drawing
    g.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight()); //Ball drawing
    System.out.println("Hier");
  }
}