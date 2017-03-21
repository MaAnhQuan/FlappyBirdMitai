import java.awt.Graphics;

public abstract class State {
	
	private static State currState = null;
	
	public static void setState(State state){
		currState = state;
	}
	
	public static State getState(){
		return currState;
	}
	
	protected Game game;
	
	public State(Game game){
		this.game = game;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
}
