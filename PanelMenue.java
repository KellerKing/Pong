import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenue extends JPanel implements ActionListener
{
	private int btnSizeW = 100;
	private int btnSizeH = 75;
	
	private JButton spielen = new JButton("Spielen");
	private JButton beenden = new JButton("Beenden");
	
	private boolean starten = false;
	private boolean stoppen = false;
	
	
	public PanelMenue()
	{
		this.setSize(Game.GAME_HEIGHT_WIDTH, Game.GAME_HEIGHT_WIDTH);
		this.setLayout(null);
		initMenuePanel();
	}
	
	public void initMenuePanel()
	{
		spielen.setBounds(Game.GAME_HEIGHT_WIDTH / 2 - btnSizeW / 2, Game.GAME_HEIGHT_WIDTH / 2 - btnSizeH*4 /2, btnSizeW, btnSizeH);
		beenden.setBounds(Game.GAME_HEIGHT_WIDTH / 2 - btnSizeW / 2, Game.GAME_HEIGHT_WIDTH / 2 - btnSizeH/3, btnSizeW, btnSizeH);
		
		this.add(spielen);
		this.add(beenden);
		
		spielen.addActionListener(this);
		beenden.addActionListener(this);
	}
	
	
	public void update()
	{
	
	}
	
	public void render()
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		starten = false;
		stoppen = false;
		
		if(e.getSource().equals(spielen))
		{
			starten = true;
		}
		else
		{
			stoppen = true;
		}
	}
	
	public boolean getStarten()
	{
		return starten;
	}
	public boolean getStoppen()
	{
		return stoppen;
	}
	
}
