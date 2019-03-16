import java.awt.Graphics;

public abstract class State
{
	protected Game game;
	protected Sprite sprites[];

	public State(Game game)
	{
		this.game = game;
	}
	
	public abstract void stateOn();
	public abstract void stateOff();
	public abstract void update();
	public abstract void render();
	
}
