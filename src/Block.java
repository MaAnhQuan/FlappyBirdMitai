
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Entity {
	
	public Block(float x, float y, int height) {
		super(x, y, 100, height);
		this.height = height;
	}

	@Override
	public void update() {
		x -= 1;
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.blockup, (int)x, (int)y, width, height, null);
	}

	public Rectangle getBound(){
		return new Rectangle((int)x, (int)y, width, height);
	}
}
