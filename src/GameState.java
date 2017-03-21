import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class GameState extends State{

	public Player player;
	private BlockManager blockManager;
	
	private int runX = 350;
	
	public GameState(Game game){
		super(game);
		player = new Player(game, 100, 150);
		blockManager = new BlockManager();
	}
	
	public void update() {
		
		player.update();
		if(runX <= 120){
			game.plusScore();
			runX = 350;
		}
		if(runX == 350){
			int ranY = randInt(50, 300);
			Block bup = new Block(runX, 0, ranY);
			blockManager.addBlock(bup);
			Block bdown = new Block(runX, ranY + 150, 400 - ranY);
			blockManager.addBlock(bdown);
		}
		runX -= 1;
		if(!blockManager.getBlockList().isEmpty())
		blockManager.update();
		checkCollisions();
	}

	public void render(Graphics g) {
		player.render(g);
		if(!blockManager.getBlockList().isEmpty())
		blockManager.render(g);
		g.setColor(Color.black );
		g.drawString(Integer.toString(game.getScore()), (int)player.getX(), (int)player.getY());
	}

	public BlockManager getBlockManager() {
		return blockManager;
	}
	
	public void checkCollisions(){
		ArrayList<Block> blocks = blockManager.getBlockList();
		for(int i = 0; i < blocks.size(); i++){
			if(player.getBound().intersects(blocks.get(i).getBound())||player.y > 470){
				System.exit(1);
			}
		}
	}
	
	public static int randInt(int min, int max){
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}	

}
