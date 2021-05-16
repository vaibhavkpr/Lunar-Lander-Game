package GameComponents;

import java.awt.Graphics2D;

import GameMedia.Media;
import GameStates.Level1State;
import Main.GamePanel;

public class Session {

	// Session Player Variables
	private int score = 0;
	private double force = 0;	
	private String state = null;
	private String landingType = null;
	private SpaceCraft ship;
	private Environment environment;
	private Level1State gp;
	
	// Session Constructor
	public Session (String state, Level1State gp) {
		this.setState(state);
		this.setGp(gp);
		ship = new SpaceCraft();
		environment = new Environment();
	}
	
	public void runSession() {	
		
//		//Calculate and update locations
//		while(!this.state.contentEquals("quit")) {
			
			
			//Check altitude and update gravity impact			
			if (ship.getShipLocationY() < 150)
			  environment.setGravity(0);  
			else
			  environment.setGravity(0.001);
			
			//Check game parameters and calculate positions
			calculate();  
			checkLanding();
			displayValues();
			
			// Check for crash and ask to replay
			if(this.state.contentEquals("crash")) {
				// display quit / play again message 
				// TODO: New Session?
				//break;
			}
		}
//	}
	
	//Update Positions on GUI
	void update() {
		
		gp.drawBg();
		// Redraw background to clear 
//		g.drawImage(m.getBackground(), 0, 0, null);
//		g.drawImage(m.getControlCenter(), 0, 0, null);
		
		// Draw Asteroids on GUI
		for(int i=0; i<environment.getAsteroids().length; i++) {
			Asteroid a = environment.getAsteroids()[i];			
			
			// Check asteroid crash on moon surface and show explosion animation
			if(a.getaLocationY() >= 485) {
				// Play crash animation
				gp.crashAnimation(a);
//				g.drawImage(m.getCrash().getFrames()[m.getCrash().getCurrentFrame()], (int) a.getaLocationX(), (int) a.getaLocationY(), null);
//				m.getCrash().update();
				a.setaVelocityX(0);
				a.setaVelocityY(0);
				
				if(gp.checkCrashAnimationCompletion()) {
					environment.getAsteroids()[i] = new Asteroid();
				}
			}
			
			// Draw asteroid if within bounds
			else {
				gp.drawAsteroid(a);
//				g.drawImage(m.getAsteroid(), (int) a.getaLocationX(), (int) a.getaLocationY(), null);
			}
		}
		
		// Draw Space Station on GUI
		gp.drawStation(environment);
//		g.drawImage(m.getSpaceStation(), (int) environment.getIssLocationX(), (int) environment.getIssLocationY(), null);
		
		// Draw Landing Pad on GUI
		gp.drawPad(environment);
//		g.drawImage(m.getLandingPad(), (int) environment.getPadLocationX(), (int) environment.getPadLocationY(), null);
		
		ship.checkRotation();
		gp.drawGraphics();
		
	}


	private void displayValues() {
		// TODO Auto-generated method stub
		
	}

	private void checkLanding() {
		// Check for successful landing
		if(ship.getShipLocationX() > environment.getPadLocationX()-2 && ship.getShipLocationX() < environment.getPadLocationX()+75 && ship.getShipLocationY() > environment.getPadLocationY()-5 && ship.getShipLocationY() < environment.getPadLocationY()) {
			if(ship.getShipLocationY() != 0) {
				ship.setForce(ship.getShipVelocityY());
				//scorefuel = fuel;
			}	
			
			// Set parameters after landing attempt
			ship.setShipVelocityX(0);
			ship.setShipVelocityY(0);
			ship.setThrust(0);
			environment.setGravity(0);
			ship.setFuel(0);
			setState("over");
			
			// Check for soft landing
			if(ship.getForce() <= 0.7 && landingType == null) {
				// Check landing angle
				if(ship.getRotation() < 30 || ship.getRotation() > 330) {
					landingType = "good";
					ship.setRotation(0);
					// wins++;
				}
				
				// Bad landing angle
				else {
					landingType = "bad";
					// loss++;
				}
			}
			
			// Check for hard landing
			if(ship.getForce() > 0.7 && landingType == null) {
				landingType = "bad";
				// loss++;
			}
			
			// Display Messages
//		    if (goodlanding) {
//		      textSize(35);
//		      textAlign(RIGHT);
//		      text("Landing Successful!", 558, 300);
//		    }
//		    if (badlanding) {
//		      ship = crash;
//		      textSize(35);
//		      textAlign(RIGHT);
//		      text("Landing Failed!", 525, 300);
//		    }
//		    //timer
//		    if (checkpoint ==1 && badlanding) {
//		      lastTime = millis();
//		      checkpoint = 0;
//		    }
//		    if (checkpoint ==1 && goodlanding) {
//		      lastTime = millis();
//		      checkpoint = 0;
//		    }
//		    if ( millis() - lastTime > 2000) {   
//		      setup();
//		    }			
		}
		
		// Check for crash with the SpaceStation
		// TODO get relative to iss Y location 
		else if(ship.getShipLocationX() > environment.getIssLocationX()-10 && ship.getShipLocationX() < environment.getIssLocationX()+72 && ship.getShipLocationY() > 20 && ship.getShipLocationY() < 105) {
			ship.setShipVelocityX(0);
			ship.setShipVelocityY(0);
			ship.setThrust(0);
			environment.setGravity(0);
			landingType = "crash";
			// over = true;
			
			// Display crashed into SpaceStation message
//		    //image(ship,shipLocationX-35,shipLocationY-35);
//		    textSize(25);
//		    textAlign(RIGHT);
//		    text("Crashed into the SpaceStation!", 560, 300);
//		    if (checkpoint ==1) {
//		      lastTime = millis();
//		      checkpoint = 0;
//		    }
//		    if ( millis() - lastTime > 2000 ) {
//		      loss++;
//		      setup();
//		    }
		}
		
		// Check if Ship goes out of bounds
		else if(ship.getShipLocationX() < 0 || ship.getShipLocationX() > 800 || ship.getShipLocationY() < -10) {
			ship.setShipVelocityX(0);
			ship.setShipVelocityY(0);
			ship.setThrust(0);
			ship.setFuel(0);
			environment.setGravity(0);
			landingType = "crash";
			// over = true;
			
			// Display ship out of bounds message
//		    textSize(25);
//		    textAlign(RIGHT);
//		    text("You flew away in Space!", 540, 250); 
//		    if (checkpoint ==1) {
//		      lastTime = millis();
//		      checkpoint = 0;
//		    }
//		    if ( millis() - lastTime > 2000 ) {
//		      loss++;
//		      setup();
//		    }
		}
		
		// Check for ship crashing on the moon
		else if(ship.getShipLocationY() > 485) {
			ship.setShipVelocityX(0);
			ship.setShipVelocityY(0);
			ship.setThrust(0);
			ship.setFuel(0);
			ship.setRotation(0);
			environment.setGravity(0);
			landingType = "crash";
			// over = true;
			
			// Display crashed on moon message
//		    ship = crash;
//		    textSize(35);
//		    textAlign(RIGHT);
//		    text("Landing Failed!", 525, 300);
//		    
//		    //delay loop
//		    if (checkpoint ==1) {
//		      lastTime = millis();
//		      checkpoint = 0;
//		    }
//		    if ( millis() - lastTime > 2000 ) {
//		      loss++;
//		      setup();
//		    }
		}
		
		// Check crash with asteroids
		for(int i=0; i<environment.getAsteroids().length; i++) {
			Asteroid a = environment.getAsteroids()[i];
			if (ship.getShipLocationX()+16 > a.getaLocationX()-10 && ship.getShipLocationX()-16 < a.getaLocationX()+10 && ship.getShipLocationY()+16 > a.getaLocationY()-10 && ship.getShipLocationY()-16 < a.getaLocationY()+10) {
				ship.setShipVelocityX(0);
				ship.setShipVelocityY(0);
				ship.setThrust(0);
				ship.setFuel(0);
				ship.setRotation(0);
				environment.setGravity(0);
				landingType = "crash";
				// over = true;
				
				// Display crashed on asteroid message
//			    //image(ship,shipLocationX-35,shipLocationY-35);
//			    textSize(25);
//			    textAlign(RIGHT);
//			    text("Crashed into an Asteroid!", 560, 300);
				
//			    if (imagecount4 == 10) {
//			      imagecount4 = 1;
//			      ship = loadImage("ship.png");
//			      aLocationX = 0;
//			      aLocationY = random(180, 290);
//			      aVelocityX = random(0.9, 1.35);
//			      aVelocityY = random(0.09, 0.30);
//			      loss++;
//			      setup();
//			    }
			}
		}		
	}

	private void calculate() {
		// Angular velocities Calculations
		ship.setShipVelocityX(ship.getShipVelocityX()-ship.getThrust()*Math.sin(Math.toRadians(ship.getRotation())));
		ship.setShipVelocityY((ship.getShipVelocityY()+ship.getThrust()*Math.cos(Math.toRadians(ship.getRotation())))+environment.getGravity());
		double x = Math.pow(ship.getShipVelocityX(), 2) + Math.pow(ship.getShipVelocityY(), 2);
		ship.setVelocity(Math.pow(x, 0.5));
		
		// Atmosphere Friction Calculations
		if(ship.getShipVelocityY() < 0) {
			ship.setShipVelocityY(ship.getShipVelocityY()+0.001);
		}
		
		// Set new Ship Locations 
		ship.setShipLocationX(ship.getShipLocationX()+ship.getShipVelocityX());
		ship.setShipLocationY(ship.getShipLocationY()+ship.getShipVelocityY());
		
		// Set new Asteroid Locations
		for(int i=0; i<environment.getAsteroids().length; i++) {
			environment.getAsteroids()[i].setaLocationX(environment.getAsteroids()[i].getaLocationX()+environment.getAsteroids()[i].getaVelocityX());
			environment.getAsteroids()[i].setaLocationY(environment.getAsteroids()[i].getaLocationY()+environment.getAsteroids()[i].getaVelocityY());
		}
		
		// Reset Out of Bound Asteroids
		for(int i=0; i<environment.getAsteroids().length; i++) {
			// Asteroid hits right boundary
			if(environment.getAsteroids()[i].getaVelocityX() > 0 && environment.getAsteroids()[i].getaLocationX() > 800) {
				environment.getAsteroids()[i].setaLocationX(0);
				environment.getAsteroids()[i].setaLocationY(environment.getAsteroids()[i].randomNumGenerator(165, 310));
			}
			// Asteroid hits left boundary
			else if(environment.getAsteroids()[i].getaVelocityX() < 0 && environment.getAsteroids()[i].getaLocationX() < -100) {
				environment.getAsteroids()[i].setaLocationX(800);
				environment.getAsteroids()[i].setaLocationY(environment.getAsteroids()[i].randomNumGenerator(170, 285));
			}
		}
		
		//Update on screen ------------------------------------------------------------ TODO add method to update graphics
		update();
		
		//Reset thrust
		ship.setThrust(0);
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the force
	 */
	public double getForce() {
		return force;
	}

	/**
	 * @param force the force to set
	 */
	public void setForce(double force) {
		this.force = force;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the landingType
	 */
	public String getLandingType() {
		return landingType;
	}

	/**
	 * @param landingType the landingType to set
	 */
	public void setLandingType(String landingType) {
		this.landingType = landingType;
	}

	/**
	 * @return the gp
	 */
	public Level1State getGp() {
		return gp;
	}

	/**
	 * @param gp2 the gp to set
	 */
	public void setGp(Level1State gp2) {
		this.gp = gp2;
	}
}
