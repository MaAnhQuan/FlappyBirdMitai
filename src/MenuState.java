import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State {

	public MenuState(Game game){
		super(game);
	}

	public void update() {
		if(game.getKeyManager().jump == true)
			State.setState(game.gameState);
	}


	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Press  Space to play", 100, 300);
	}

}
