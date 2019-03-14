
public class StateGame extends State
{
	private PanelGame panelGame = new PanelGame();
	
	public StateGame(Game game)
	{
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void stateOn()
	{
		game.getFrame().add(panelGame);
		panelGame.setVisible(true);
	}

	@Override
	public void stateOff()
	{
		panelGame.setVisible(false);
		game.getFrame().remove(panelGame);
	}

	@Override
	public void update()
	{
		panelGame.update();
	}

	@Override
	public void render()
	{
		panelGame.render();
	}

}
