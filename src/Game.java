import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

	private Display display;
	private Thread thread;
	private boolean running = false;
	
	public int width, height;
	public String title;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public State gameState;
	public State menuState;
	public State overState;
	
	private KeyManager keyManager;
	private int score;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);;
		Assets.init();
		score = 0;
		menuState = new MenuState(this);
		gameState = new GameState(this);
		overState = new OverState(this);
		State.setState(menuState);
	}
	
	private void update(){
		keyManager.update();
		if(State.getState() != null)
			State.getState().update();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy(); 
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		 
		if(State.getState() != null)
			State.getState().render(g);
		
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 100;
		double timePerUpdate = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerUpdate;
			lastTime = now;
			
			if(delta >= 1){
				update();
				render();
				delta--;
			}
			
		}
		
		stop();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public synchronized void start(){
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void plusScore(){
		score++;
	}
	
	public int getScore(){
		return score;
	}
}
