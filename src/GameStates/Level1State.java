package GameStates;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameComponents.Asteroid;
import GameComponents.Environment;
import GameComponents.Session;
import GameMedia.Background;
import GameMedia.Media;
import Main.GamePanel;

import javax.swing.*;

public class Level1State extends State {
	
	Session player;
	private Background bg;
	private Media media;
//	private GamePanel gp;
	private Graphics2D g;
	private ArrayList<Frame> frameGraphics;
	
	// Game States Manager
	private StateMgr stateMgr;
	
	public class Frame{
		int x;
		int y;
		BufferedImage img;
		
		public Frame(int x, int y, BufferedImage img) {
			this.x = x;
			this.y = y;
			this.img = img;
		}
	}
	
	// Level 1 Constructor
	public Level1State(StateMgr mgr) {
		this.stateMgr = mgr;
		this.media = new Media();
		player = new Session("validSession", this);
		frameGraphics = new ArrayList<Frame>();
		//initialize();
	}
	
	public void initialize(Graphics2D g) {
		try {
			bg = new Background("/moon.png", 1);
			bg.setVector(0, 0); //(-0.1,0)
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		player.runSession();
	}
	
	public void draw(Graphics2D g) {
		//player.setGraphics(g);
		this.g = g;
		//bg.draw(g);
//		g.drawImage(media.getBackground(), 0, 0, null);
//		g.drawImage(media.getControlCenter(), 0, 0, null);
		//drawGraphics();
	}
	
	public void keyPressed(int key) {
		
	}
	
	public void keyReleased(int key) {
		
	}
	
	public void drawGraphics() {		
		//g.drawImage(media.getBackground(), 0, 0, null);
		//g.drawImage(media.getControlCenter(), 0, 0, null);
		
		//Graphics2D g2 = (Graphics2D) new BufferedImage(800, 650, BufferedImage.TYPE_INT_BGR).getGraphics();	
		for(int i=0; i<frameGraphics.size(); i++){			
			g.drawImage(frameGraphics.get(i).img, frameGraphics.get(i).x, frameGraphics.get(i).y, null);
		}
		g.drawImage(media.getControlCenter(), 0, 0, null);
		// Clear drawn frames
		frameGraphics = new ArrayList<Frame>();
		//g2.dispose();
	}

	public void drawBg() {
		//Graphics g3 = getGraphics();
		//g3.drawImage(img, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		frameGraphics.add(new Frame(0, 0, media.getBackground())); 
//		g = (Graphics2D) getGraphics();
//		g.drawImage(m.getBackground(), 0, 0, null);
//		g.drawImage(m.getControlCenter(), 0, 0, null);	
		//g3.dispose();
	}

	public void crashAnimation(Asteroid a) {
		//Graphics g3 = getGraphics();
		//g3.drawImage(m.getCrash().getFrames()[m.getCrash().getCurrentFrame()], (int) a.getaLocationX(), (int) a.getaLocationY(), null);
		frameGraphics.add(new Frame((int) a.getaLocationX(), (int) a.getaLocationY(), media.getCrash().getFrames()[media.getCrash().getCurrentFrame()]));
		media.getCrash().update();
		//g3.dispose();
		
	}	
	
	public boolean checkCrashAnimationCompletion() {
		return media.getCrash().isPlayed();
	}

	public void drawAsteroid(Asteroid a) {
//		Graphics g3 = getGraphics();
//		g3.drawImage(m.getAsteroid(), (int) a.getaLocationX(), (int) a.getaLocationY(), null);		
		frameGraphics.add(new Frame((int) a.getaLocationX(), (int) a.getaLocationY(), media.getAsteroid()));
//		g3.dispose();
	}

	public void drawStation(Environment environment) {
//		Graphics g3 = getGraphics();
//		g3.drawImage(m.getSpaceStation(), (int) environment.getIssLocationX(), (int) environment.getIssLocationY(), null);	
		frameGraphics.add(new Frame((int) environment.getIssLocationX(), (int) environment.getIssLocationY(), media.getSpaceStation()));
//		g3.dispose();
	}

	public void drawPad(Environment environment) {
//		Graphics g3 = getGraphics();
//		g3.drawImage(m.getLandingPad(), (int) environment.getPadLocationX(), (int) environment.getPadLocationY(), null);
		frameGraphics.add(new Frame((int) environment.getPadLocationX(), (int) environment.getPadLocationY(), media.getLandingPad()));
//		g3.dispose();		
	}

	/**
	 * @return the frameGraphics
	 */
	public ArrayList<Frame> getFrameGraphics() {
		return frameGraphics;
	}

	/**
	 * @param frameGraphics the frameGraphics to set
	 */
	public void setFrameGraphics(ArrayList<Frame> frameGraphics) {
		this.frameGraphics = frameGraphics;
	}
}
