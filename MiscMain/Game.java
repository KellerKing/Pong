/*
 * Copyright by Luca Keller
 */

package MiscMain;

import GameObjects.Ball;
import GameObjects.Ki;
import GameObjects.Paddle;
import States.GameStateManager;

import javax.swing.JFrame;
import java.util.Random;

public class Game extends Thread
{

  private Random r = new Random();

  private Settings settings = new Settings(); //TODO

  public static final int GAME_HEIGHT_WIDTH = 1000;
  public static boolean leuft = true;
  private final static double FPS = 60;
  private final static double FRAMETIME = (1 / FPS) * 1000000000; // nanosekunden

  //TODO
  private Paddle player1 = new Paddle(GAME_HEIGHT_WIDTH/2 - 100,GAME_HEIGHT_WIDTH - 100,200,50);
  private Paddle player2 = new Ki(GAME_HEIGHT_WIDTH/2 - 100, 15,200,50);
  private Ball ball = new Ball(GAME_HEIGHT_WIDTH / 2 - 50,GAME_HEIGHT_WIDTH/2 -50,50,50);

  private JFrame frame = new JFrame();

  private GameStateManager gsm = new GameStateManager(this);


  public Game() throws InterruptedException
  {
    frame.setTitle("Pong by Luca Keller");
    frame.setSize(GAME_HEIGHT_WIDTH, GAME_HEIGHT_WIDTH);
    frame.setLayout(null);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setVisible(true);

    gsm.setState(GameStateManager.STATE_MENUE);

    loop();
  }

  public static void main(String[] argv) throws InterruptedException
  {
    new Game();
  }

  public void loop() throws InterruptedException
  {
    long frameStart;
    long frameEnd;
    long frameDuration;
    long sleepTime; // Nanosekunden

    // GameLoop mit festeingestellten 60 FPS
    while (leuft) {
      frameStart = System.nanoTime();

      update();
      render();

      frameEnd = System.nanoTime();
      frameDuration = frameEnd - frameStart;

      while (frameDuration < FRAMETIME) {
        sleepTime = (long) ((FRAMETIME - frameDuration) / 1000000);
        sleep(sleepTime);
        frameDuration = System.nanoTime() - frameStart;
      }
      yield();
    }
    System.exit(0);
  }

  public void update()
  {
    gsm.getState().update();
  }

    public void render()
  {
    gsm.getState().render();
  }

  public GameStateManager getGSM()
  {
    return gsm;
  }

  public JFrame getFrame()
  {
    return frame;
  }

  public Ball getBall()
  {
    return ball;
  }

  public Paddle getPlayer1()
  {
    return player1;
  }

  public Paddle getPlayer2()
  {
    return player2;
  }
}
