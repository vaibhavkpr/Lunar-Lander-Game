package GameMedia;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Media {
	// Class Variables
	private BufferedImage background;				// Space theme Backdrop for game
	private BufferedImage ship;						// SpaceCraft 
	private BufferedImage shipThrust;				// Exhaust animation
	private BufferedImage shipDown;					// Down exhaust
	private BufferedImage controlCenter;			// Control center overlay to show statistics
	private BufferedImage spaceStation;				// Space Station where SpaceCraft is docked to
	private BufferedImage shipLeft;					// Left exhaust
	private BufferedImage shipRight;				// Right exhaust
	private BufferedImage landingPad;				// Landing pad
	private Animation crash;						// Crash animation
	private BufferedImage asteroid;					// Asteroid
	
	// Default Constructor
	public Media() {
		loadImages();
	}

	private void loadImages() {
		try {
			setBackground(ImageIO.read(getClass().getResourceAsStream("/moon.png")));
			setShip(ImageIO.read(getClass().getResourceAsStream("/ship.png")));
			setShipThrust(ImageIO.read(getClass().getResourceAsStream("/shipfire.png")));
			//shipDown = ImageIO.read(getClass().getResourceAsStream("/controlcenter.png"));
			setControlCenter(ImageIO.read(getClass().getResourceAsStream("/controlcenter.png")));
			setSpaceStation(ImageIO.read(getClass().getResourceAsStream("/station.png")));
			setShipLeft(ImageIO.read(getClass().getResourceAsStream("/shipleft.png")));
			setShipRight(ImageIO.read(getClass().getResourceAsStream("/shipright.png")));
			setLandingPad(ImageIO.read(getClass().getResourceAsStream("/landingpad.png")));
			//setCrash(ImageIO.read(getClass().getResourceAsStream("/explosion.png")));
			setAsteroid(ImageIO.read(getClass().getResourceAsStream("/asteroid.png")));
			crash = new Animation();
			crash.setFrames(new BufferedImage[10]);
			crash.setDelay(100);
			for(int i=0; i<crash.getFrames().length; i++) {
				crash.getFrames()[i] = ImageIO.read(getClass().getResourceAsStream("/aexp" + String.valueOf(i+1) +".png"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}

	/**
	 * @return the background
	 */
	public BufferedImage getBackground() {
		return background;
	}

	/**
	 * @param background the background to set
	 */
	public void setBackground(BufferedImage background) {
		this.background = background;
	}

	/**
	 * @return the ship
	 */
	public BufferedImage getShip() {
		return ship;
	}

	/**
	 * @param ship the ship to set
	 */
	public void setShip(BufferedImage ship) {
		this.ship = ship;
	}

	/**
	 * @return the shipThrust
	 */
	public BufferedImage getShipThrust() {
		return shipThrust;
	}

	/**
	 * @param shipThrust the shipThrust to set
	 */
	public void setShipThrust(BufferedImage shipThrust) {
		this.shipThrust = shipThrust;
	}

	/**
	 * @return the shipDown
	 */
	public BufferedImage getShipDown() {
		return shipDown;
	}

	/**
	 * @param shipDown the shipDown to set
	 */
	public void setShipDown(BufferedImage shipDown) {
		this.shipDown = shipDown;
	}

	/**
	 * @return the controlCenter
	 */
	public BufferedImage getControlCenter() {
		return controlCenter;
	}

	/**
	 * @param controlCenter the controlCenter to set
	 */
	public void setControlCenter(BufferedImage controlCenter) {
		this.controlCenter = controlCenter;
	}

	/**
	 * @return the spaceStation
	 */
	public BufferedImage getSpaceStation() {
		return spaceStation;
	}

	/**
	 * @param spaceStation the spaceStation to set
	 */
	public void setSpaceStation(BufferedImage spaceStation) {
		this.spaceStation = spaceStation;
	}

	/**
	 * @return the shipLeft
	 */
	public BufferedImage getShipLeft() {
		return shipLeft;
	}

	/**
	 * @param shipLeft the shipLeft to set
	 */
	public void setShipLeft(BufferedImage shipLeft) {
		this.shipLeft = shipLeft;
	}

	/**
	 * @return the shipRight
	 */
	public BufferedImage getShipRight() {
		return shipRight;
	}

	/**
	 * @param shipRight the shipRight to set
	 */
	public void setShipRight(BufferedImage shipRight) {
		this.shipRight = shipRight;
	}

	/**
	 * @return the landingPad
	 */
	public BufferedImage getLandingPad() {
		return landingPad;
	}

	/**
	 * @param landingPad the landingPad to set
	 */
	public void setLandingPad(BufferedImage landingPad) {
		this.landingPad = landingPad;
	}

	/**
	 * @return the crash
	 */
	public Animation getCrash() {
		return crash;
	}

	/**
	 * @param crash the crash to set
	 */
	public void setCrash(Animation crash) {
		this.crash = crash;
	}

	/**
	 * @return the asteroid
	 */
	public BufferedImage getAsteroid() {
		return asteroid;
	}

	/**
	 * @param asteroid the asteroid to set
	 */
	public void setAsteroid(BufferedImage asteroid) {
		this.asteroid = asteroid;
	}

}

//public Media(){
//	try {
//		img = ImageIO.read(getClass().getResourceAsStream("images/background.png"));
//		
//	}
//	catch(Exception e) {
//		//e.printStackTrace();
//	}
//	//setBackground(new ImageIcon("images//background.png"));
//	setControlCenter(new ImageIcon("controlcenter.png"));
//	setSpaceStation(new ImageIcon("station.png"));
//  	setShip(new ImageIcon("ship.png"));
//  	setShipThrust(new ImageIcon("shipfire.png"));
//  	setShipRight(new ImageIcon("shipright.png"));
//  	setShipLeft(new ImageIcon("shipleft.png"));
//  	setLandingPad(new ImageIcon("landingpad.png"));
//  	setCrash(new ImageIcon("explosion.png"));
//  	setAsteroid(new ImageIcon("asteroid.png"));
//}
//
//// Getters and Setters
//
///**
// * @return the background
// */
//public BufferedImage getBackground() {
//	return background;
//}
//
///**
// * @param background the background to set
// */
//public void setBackground(BufferedImage background) {
//	this.background = background;
//}
//
///**
// * @return the ship
// */
//public ImageIcon getShip() {
//	return ship;
//}
//
///**
// * @param ship the ship to set
// */
//public void setShip(ImageIcon ship) {
//	this.ship = ship;
//}
//
///**
// * @return the shipThrust
// */
//public ImageIcon getShipThrust() {
//	return shipThrust;
//}
//
///**
// * @param shipThrust the shipThrust to set
// */
//public void setShipThrust(ImageIcon shipThrust) {
//	this.shipThrust = shipThrust;
//}
//
///**
// * @return the shipdown
// */
//public ImageIcon getShipdown() {
//	return shipdown;
//}
//
///**
// * @param shipdown the shipdown to set
// */
//public void setShipdown(ImageIcon shipdown) {
//	this.shipdown = shipdown;
//}
//
///**
// * @return the controlCenter
// */
//public ImageIcon getControlCenter() {
//	return controlCenter;
//}
//
///**
// * @param controlCenter the controlCenter to set
// */
//public void setControlCenter(ImageIcon controlCenter) {
//	this.controlCenter = controlCenter;
//}
//
///**
// * @return the spaceStation
// */
//public ImageIcon getSpaceStation() {
//	return spaceStation;
//}
//
///**
// * @param spaceStation the spaceStation to set
// */
//public void setSpaceStation(ImageIcon spaceStation) {
//	this.spaceStation = spaceStation;
//}
//
///**
// * @return the shipLeft
// */
//public ImageIcon getShipLeft() {
//	return shipLeft;
//}
//
///**
// * @param shipLeft the shipLeft to set
// */
//public void setShipLeft(ImageIcon shipLeft) {
//	this.shipLeft = shipLeft;
//}
//
///**
// * @return the shipRight
// */
//public ImageIcon getShipRight() {
//	return shipRight;
//}
//
///**
// * @param shipRight the shipRight to set
// */
//public void setShipRight(ImageIcon shipRight) {
//	this.shipRight = shipRight;
//}
//
///**
// * @return the landingPad
// */
//public ImageIcon getLandingPad() {
//	return landingPad;
//}
//
///**
// * @param landingPad the landingPad to set
// */
//public void setLandingPad(ImageIcon landingPad) {
//	this.landingPad = landingPad;
//}
//
///**
// * @return the crash
// */
//public ImageIcon getCrash() {
//	return crash;
//}
//
///**
// * @param crash the crash to set
// */
//public void setCrash(ImageIcon crash) {
//	this.crash = crash;
//}
//
///**
// * @return the asteroid
// */
//public ImageIcon getAsteroid() {
//	return asteroid;
//}
//
///**
// * @param asteroid the asteroid to set
// */
//public void setAsteroid(ImageIcon asteroid) {
//	this.asteroid = asteroid;
//}
//
///**
// * @return the img
// */
//public BufferedImage getImg() {
//	return img;
//}
//
///**
// * @param img the img to set
// */
//public void setImg(BufferedImage img) {
//	this.img = img;
//}
//
///**
// * @return the g
// */
//public Graphics2D getG() {
//	return g;
//}
//
///**
// * @param g the g to set
// */
//public void setG(Graphics2D g) {
//	this.g = g;
//}



//background = loadImage("background.png");
//ship;
//shipThrust;
//shipdown;
//controlCenter;
//spaceStation;
//shipLeft;
//shipRight;
//landingPad;
//crash;
//asteroid;
//
//  background = loadImage("moon.png");
//  controlCenter = loadImage("controlcenter.png");
//  spaceStation = loadImage("station.png");
//  ship = loadImage("ship.png");
//  shipThrust = loadImage("shipfire.png");
//  shipRight = loadImage("shipright.png");
//  shipLeft = loadImage("shipleft.png");
//  landingPad = loadImage("landingpad.png");
//  crash = loadImage("explosion.png");
//  asteroid = loadImage("asteroid.png");
//  asteroid2 = loadImage("asteroid.png");
//  asteroid3 = loadImage("asteroid.png");