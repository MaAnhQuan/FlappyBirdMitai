import java.awt.Graphics;
import java.util.ArrayList;

public class BlockManager {
	
	private ArrayList<Block> blocks;
	
	public BlockManager(){
		blocks = new ArrayList<Block>();
	}
	
	public ArrayList<Block> getBlockList(){
		return blocks;
	}
	
	public void addBlock(Block b){
		blocks.add(b);
	}
	
	public void removeBlock(Block b){
		blocks.remove(b);
	}
	
	public void update(){
		for(int i = 0; i < blocks.size(); i++){
			Block tmp = blocks.get(i);
			tmp.update();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < blocks.size(); i++){
			Block tmp = blocks.get(i);
			tmp.render(g);
		}
	}
}
