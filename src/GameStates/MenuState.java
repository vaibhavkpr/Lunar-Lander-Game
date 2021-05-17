package GameStates;
import java.awt.*;
import java.awt.event.KeyEvent;

import GameMedia.Background;

public class MenuState extends State {
	
	private Background bg;
	private int currentChoice = 0;
	private String[] options = {"Start", "Help", "Quit"};	
	private Color titleColor;
	private Color optionColor;
	private Font titleFont;
	private Font font;	
	private Graphics2D g;

	public MenuState(StateMgr stateMgr) {
		this.stateMgr = stateMgr;
		try {
			bg = new Background("/moon.png", 1);
			bg.setVector(0, 0); //(-0.1,0)
			titleColor = new Color(200,200,200);
			optionColor = new Color(200,200,200);
			titleFont = new Font("Arial", Font.PLAIN, 75);
			font = new Font("Calibri", Font.PLAIN, 30);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initialize() {}
	
	public void update() {
		bg.update();
	}
	
	public void draw(Graphics2D g) {
		
		this.g = g;
		
		// Draw bg
		bg.draw(g);
		
		// Draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Lunar Lander", 175, 200);
		
		// Draw menu options
		g.setFont(font);
		g.setColor(optionColor);
		
		for(int i=0; i<options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.RED);
			}
			else {
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 350, 340 + i * 35);
		}
	}
	
	public void select() {
		
		// Play Game choice
		if(currentChoice == 0) {
			stateMgr.setCurrentState(stateMgr.LEVEL1);
			stateMgr.draw(g);
			//stateMgr.getGameStates().get(stateMgr.LEVEL1).initialize();
			//stateMgr.getGameStates().get(stateMgr.LEVEL1).draw(g);
		}
		
		// Help choice
		if(currentChoice == 1) {
			
		}
		
		// Quit game
		if(currentChoice == 2) {
			
		}
	}
	
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_ENTER) {
			select();
		}
		if(key == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length-1;
			}
		}
		if(key == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}
	
	public void keyReleased(int key) {
		
	}

}
