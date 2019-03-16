
public class GameStateManager
{

	private Game game;
	private State currentState;
	private State[] states = new State[3];

	public static final int STATE_MENUE = 0, STATE_GAME = 1, STATE_OPTION = 2;

	public GameStateManager(Game game)
	{
		this.game = game;
		states[STATE_MENUE] = new StateMenue(this.game);
		states[STATE_GAME] = new StateGame(this.game);
//		states[STATE_OPTION] = new StateOption(this.game);
	}

	public void setState(int stateWert)
	{
		if (currentState != null)
		{
			this.currentState.stateOff();
		}
		this.currentState = states[stateWert];

		this.currentState.stateOn();
	}

	public State getState()
	{
		return currentState;
	}
}