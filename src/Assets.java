import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage player, blockup, blockdown;
	public static final int WIDTH = 32, HEIGHT = 32;
	
	public static void init(){
		SpriteSheet	sheet = new SpriteSheet(ImageLoader.loadImage("/images/images.png"));
		player = sheet.crop(0, 0, 101, 73);
		sheet = new SpriteSheet(ImageLoader.loadImage("/images/blockup.png"));
		blockup = sheet.crop(0, 0, 56, 150);
		sheet = new SpriteSheet(ImageLoader.loadImage("/images/blockdown.png"));
		blockdown = sheet.crop(0, 0, 56, 150);
	}
}
