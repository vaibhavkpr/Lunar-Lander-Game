package Main;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;

import GameComponents.Asteroid;
import GameComponents.Environment;
import GameMedia.Background;
import GameMedia.Media;
//import Media;
//import Session;
import GameStates.StateMgr;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	// Dimensions
	public static final int WIDTH = 800;
	public static final int HEIGHT = 650;
	public static final int SCALE = 1;
	
	// Game thread
	private Thread thread;
	private boolean running;
	private int FPS = 120;
	private long targetTime = 1000/FPS;
//	private ArrayList<Frame> frameGraphics;
	
	//private Media media;
	//private Session player;
	
	// Image
	private BufferedImage img;
	private Graphics2D g;
//	private Media m;
	
//	// Game States Manager
	private StateMgr stateMgr;
//	
//	public class Frame{
//		int x;
//		int y;
//		BufferedImage img;
//		
//		public Frame(int x, int y, BufferedImage img) {
//			this.x = x;
//			this.y = y;
//			this.img = img;
//		}
//	}
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
		//this.m = new Media();
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	private void initialize() {
		// Setup Objects
//		media = new Media();
//		media.setImg(new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB));
//		media.setG((Graphics2D) media.getG());
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
		g = (Graphics2D) img.getGraphics();		
		running = true;
		stateMgr = new StateMgr();
		
//		player = new Session("validSession");	
		//player.runSession();	
	}
	
	public void run() {
		initialize();
		
		long startTime;
		long elapsedTime;
		long wait;
		
		// Game Loop
		while(running) {
			startTime = System.nanoTime();
			update();
			draw();
			drawToScreen();
			elapsedTime = System.nanoTime() - startTime;
			wait = targetTime - elapsedTime / 1000000;
			
			if(wait < 0) {
				wait = 0;
			}
			
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(img, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		g2.dispose();		
	}

	private void draw() {
		stateMgr.draw(g);		
	}

	private void update() {
		stateMgr.update();		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		stateMgr.keyPressed(e.getKeyCode());		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		stateMgr.keyReleased(e.getKeyCode());		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub		
	}
	
//	public void drawGraphics() {
//		Graphics g2 = (Graphics2D) getGraphics();
//		for(int i=0; i<frameGraphics.size(); i++){			
//			g2.drawImage(frameGraphics.get(i).img, frameGraphics.get(i).x, frameGraphics.get(i).y, null);
//		}
//		g2.dispose();
//	}
//
//	public void drawBg() {
//		//Graphics g3 = getGraphics();
//		//g3.drawImage(img, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
//		frameGraphics = new ArrayList<Frame>();
//		frameGraphics.add(new Frame(0, 0, m.getBackground()));
//		frameGraphics.add(new Frame(0, 0, m.getControlCenter()))
//		; 
////		g = (Graphics2D) getGraphics();
////		g.drawImage(m.getBackground(), 0, 0, null);
////		g.drawImage(m.getControlCenter(), 0, 0, null);	
//		//g3.dispose();
//	}
//
//	public void crashAnimation(Asteroid a) {
//		//Graphics g3 = getGraphics();
//		//g3.drawImage(m.getCrash().getFrames()[m.getCrash().getCurrentFrame()], (int) a.getaLocationX(), (int) a.getaLocationY(), null);
//		frameGraphics.add(new Frame((int) a.getaLocationX(), (int) a.getaLocationY(), m.getCrash().getFrames()[m.getCrash().getCurrentFrame()]));
//		m.getCrash().update();
//		//g3.dispose();
//		
//	}	
//	
//	public boolean checkCrashAnimationCompletion() {
//		return m.getCrash().isPlayed();
//	}
//
//	public void drawAsteroid(Asteroid a) {
////		Graphics g3 = getGraphics();
////		g3.drawImage(m.getAsteroid(), (int) a.getaLocationX(), (int) a.getaLocationY(), null);		
//		frameGraphics.add(new Frame((int) a.getaLocationX(), (int) a.getaLocationY(), m.getAsteroid()));
////		g3.dispose();
//	}
//
//	public void drawStation(Environment environment) {
////		Graphics g3 = getGraphics();
////		g3.drawImage(m.getSpaceStation(), (int) environment.getIssLocationX(), (int) environment.getIssLocationY(), null);	
//		frameGraphics.add(new Frame((int) environment.getIssLocationX(), (int) environment.getIssLocationY(), m.getSpaceStation()));
////		g3.dispose();
//	}
//
//	public void drawPad(Environment environment) {
////		Graphics g3 = getGraphics();
////		g3.drawImage(m.getLandingPad(), (int) environment.getPadLocationX(), (int) environment.getPadLocationY(), null);
//		frameGraphics.add(new Frame((int) environment.getPadLocationX(), (int) environment.getPadLocationY(), m.getLandingPad()));
////		g3.dispose();
//		
//	}
//
//	/**
//	 * @return the frameGraphics
//	 */
//	public ArrayList<Frame> getFrameGraphics() {
//		return frameGraphics;
//	}
//
//	/**
//	 * @param frameGraphics the frameGraphics to set
//	 */
//	public void setFrameGraphics(ArrayList<Frame> frameGraphics) {
//		this.frameGraphics = frameGraphics;
//	}
}


















//JFrame gameWindow = new JFrame();
//private Media media;
//
//public GameWindow(Media m){
//	media = m;
//	gameWindow.add(this);
//	gameWindow.setTitle("Lunar Lander");
//	gameWindow.setSize(800,650);
//	gameWindow.setVisible(true);
//	gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//}
//
//public void paint(Graphics g) {
//	JLabel bg = new JLabel(media.getBackground());
//	add(bg);
//	g.drawImage(media.getBackground().getImage(),0,0,null);
//}