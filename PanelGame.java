import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelGame extends JPanel
{

	public PanelGame()
	{
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

	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		System.out.println("asdasdas");
		g.drawString("asdasd", 100, 100);

	}
}