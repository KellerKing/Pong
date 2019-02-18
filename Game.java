import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game
{
	private JFrame frame;
	private GameField gameField;
	private static Game game;

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 700;

	private Random random;
	private Paddle player1;
	private Paddle player2;
	private Ball ball;

	private byte state = 0; // 0 = Start / 1 = Game / 2 = Pause
	
	boolean running = true;

	public Game()
	{	
		
		gameField = new GameField(this);
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gameField);

		frame.setVisible(true);
		dauerschleife();

	}
	
	public void initGame()
	{
		ball = new Ball(WIDTH / 2, HEIGHT / 2);
	}
	
	public void dauerschleife()
	{
		
		
		long timeInit = System.nanoTime(); 
		final int FPS = 60;
		final long DELAY_TIME = 1000000000 / FPS;
		
		double delta = 0;
		int frames = 0;
		
		long timer = System.currentTimeMillis();

		while(running)
		{
			long timeNow = System.nanoTime();
			delta += (timeNow - timeInit) / DELAY_TIME;
			timeInit = timeNow;
			
			while(delta >= 1)
			{
				update();
				
				delta--;
				frames++;
			}
			render();
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				frames = 0;
			}
		}
		System.exit(1);
	}

	public void render()
	{
		System.out.println(this.state);
		gameField.revalidate();
		gameField.repaint();
	}

	public void update()
	{

	}

	public static void main(String[] args)
	{
		game = new Game();
	}


	public byte getState()
	{
		return state;

	}

	public void setState(byte state)
	{
		this.state = state;
	}

}

class GameField extends JPanel implements KeyListener, ActionListener
{
	private Game game;
	
	private JButton spielen = new JButton("Spielen");
	private JButton beenden = new JButton("Beenden");
	
	private int buttonWidth = Game.WIDTH / 7;
	private int buttonHeight = Game.HEIGHT / 7;

	public GameField(Game game)
	{
		this.game = game;
		this.setSize(Game.WIDTH, Game.HEIGHT);
		this.setLayout(null);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(this);
		
		initComp();
		
		
		
		this.setVisible(true);
		
		
	}
	
	public void initComp()
	{
		spielen.setBounds((Game.WIDTH / 2) - (buttonWidth / 2), (Game.HEIGHT / 3) - (buttonHeight / 2), buttonWidth, buttonHeight);
		beenden.setBounds((Game.WIDTH / 2) - (buttonWidth / 2), (Game.HEIGHT / 2) - (buttonHeight / 2), buttonWidth, buttonHeight);
		
		
		spielen.addActionListener(this);
		beenden.addActionListener(this);
		
		this.add(spielen);
		this.add(beenden);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		switch (game.getState())
		{
		case 0:
			spielen.setVisible(true);
			beenden.setVisible(true);
			
			break;
		case 1:
			spielen.setVisible(false);
			spielen.setVisible(false);
			
			paintBall(g);
			paintPaddle(g);
			
			break;
		case 2:
			break;
		default:
			break;
		}


	}

	public void paintBall(Graphics g)
	{
		
	}

	public void paintPaddle(Graphics g)
	{

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == spielen)
		{
			game.setState((byte)1);
			
		}
		else if (e.getSource() == beenden)
		{
			
			game.running = false;
		}

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		switch (game.getState())
		{
		case 0:

			break;
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_UP)
			{

			} else if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{

			} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				game.setState((byte) 2);
			}
			break;
		case 2:
			// TODO KeyEvent
			break;

		default:
			break;
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

}
