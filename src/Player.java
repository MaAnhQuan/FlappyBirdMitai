import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Entity {

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y, 30, 30);
		this.game = game;
	}

	@Override
	public void update() {
		y += 2;
		if(game.getKeyManager().jump && y > 0){
			y -= 6;
		}	
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, width, height, null);
	}

	@Override
	public Rectangle getBound() {
		return new Rectangle((int)x, (int)y, width, height);   
	}

}
