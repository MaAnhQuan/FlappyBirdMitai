import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

	protected float x, y;
	protected int width, height;
	
	public Entity(float x, float y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	public abstract Rectangle getBound();

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
}
