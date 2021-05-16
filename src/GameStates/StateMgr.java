package GameStates;
import java.awt.Graphics2D;
import java.util.ArrayList;

import GameMedia.Media;
import Main.GamePanel;

public class StateMgr {
	
	private ArrayList<State> gameStates;
	private int currentState;
//	private GamePanel gp;
	
	public static final int MENUSTATE = 0;
	public static final int LEVEL1 = 1;
	
	public StateMgr() {
		//this.gp = gp;
		setGameStates(new ArrayList<State>());		
		getGameStates().add(new MenuState(this));
		getGameStates().add(new Level1State(this));
		setCurrentState(MENUSTATE);
	}
	
	public State getState(int state) {
		return getGameStates().get(state);
	}

	/**
	 * @return the currentState
	 */
	public int getCurrentState() {
		return currentState;
	}

	/**
	 * @param currentState the currentState to set
	 */
	public void setCurrentState(int currentState) {
		this.currentState = currentState;
		//getGameStates().get(currentState).initialize();
	}
	
	public void update() {
		getGameStates().get(currentState).update();
	}
	
	public void draw(Graphics2D g) {
		getGameStates().get(currentState).draw(g);
	}
	
	public void keyPressed(int key) {
		getGameStates().get(currentState).keyPressed(key);
	}
	
	public void keyReleased(int key) {
		getGameStates().get(currentState).keyReleased(key);
	}

	/**
	 * @return the gameStates
	 */
	public ArrayList<State> getGameStates() {
		return gameStates;
	}

	/**
	 * @param gameStates the gameStates to set
	 */
	public void setGameStates(ArrayList<State> gameStates) {
		this.gameStates = gameStates;
	}

}
