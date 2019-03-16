
public class StateGame extends State
{
	private PanelGame panelGame;
	
	public StateGame(Game game)
	{
		super(game);
		panelGame = new PanelGame(game);
	}

	@Override
	public void stateOn()
	{
		game.getFrame().add(panelGame);
		panelGame.requestFocus();
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
