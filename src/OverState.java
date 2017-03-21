import java.awt.Color;
import java.awt.Graphics;

public class OverState extends State {
	
	public OverState(Game game){
		super(game);
	}
	
	public void update() {

		if(game.getKeyManager().jump == true)
			State.setState(game.menuState);
		
	}

	public void render(Graphics g) {
		int sc = game.getScore();
		g.setColor(Color.red);
		g.drawString(Integer.toString(sc), 0, 0);
		
	}

}
