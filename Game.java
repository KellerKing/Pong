import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game extends Thread
{
	
	public static final int GAME_HEIGHT_WIDTH = 1000;
	public static boolean leuft = true;
	private final static double FPS = 60;
	private final static double FRAMETIME = (1 / FPS) * 1000000000; // nanosekunden
	
	private GameStateManager gsm = new GameStateManager(this);
	
	
	public Game() throws InterruptedException
	{
		JFrame frame = new JFrame();
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
		while (leuft)
		{
			frameStart = System.nanoTime();

			update();
			render();

			frameEnd = System.nanoTime();
			frameDuration = frameEnd - frameStart;

			while (frameDuration < FRAMETIME)
			{
				sleepTime = (long) ((FRAMETIME - frameDuration) / 1000000);
				sleep(sleepTime);
				frameDuration = System.nanoTime() - frameStart;
			}
			yield();
		}
		System.exit(1);
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
		return getFrame();
	}
	

}
