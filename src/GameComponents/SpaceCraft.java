package GameComponents;

public class SpaceCraft {
	
	// SpaceCraft Parameters
	private double shipLocationX;
	private double shipLocationY;
	private double shipVelocityX;
	private double shipVelocityY;
	private double shipAcceleration;
	private double fuel;
	private double thrust;
	private double force;
	private double rotation;
	private double velocity;
	
	// Default Constructor
	public SpaceCraft() {
		 setShipLocationX(198);
		 setShipLocationY(65);
		 setFuel(3000);
		 setRotation(90);
	}
	
	//Check rotations
	public void checkRotation() {
	  if (rotation == 360 || rotation == -360) {
	    rotation = 0;
	  }	  
//	  pushMatrix();
//	  translate(shipLocationX, shipLocationY);
//	  rotate(radians(rotation));
//	  image(ship, -ship.width/2, -ship.height/2);  
//	  //image(ship,shipLocationX,shipLocationY);
//	  popMatrix();
	}

	/**
	 * @return the shipLocationX
	 */
	public double getShipLocationX() {
		return shipLocationX;
	}

	/**
	 * @param shipLocationX the shipLocationX to set
	 */
	public void setShipLocationX(double shipLocationX) {
		this.shipLocationX = shipLocationX;
	}

	/**
	 * @return the shipLocationY
	 */
	public double getShipLocationY() {
		return shipLocationY;
	}

	/**
	 * @param shipLocationY the shipLocationY to set
	 */
	public void setShipLocationY(double shipLocationY) {
		this.shipLocationY = shipLocationY;
	}

	/**
	 * @return the shipVelocityX
	 */
	public double getShipVelocityX() {
		return shipVelocityX;
	}

	/**
	 * @param shipVelocityX the shipVelocityX to set
	 */
	public void setShipVelocityX(double shipVelocityX) {
		this.shipVelocityX = shipVelocityX;
	}

	/**
	 * @return the shipVelocityY
	 */
	public double getShipVelocityY() {
		return shipVelocityY;
	}

	/**
	 * @param shipVelocityY the shipVelocityY to set
	 */
	public void setShipVelocityY(double shipVelocityY) {
		this.shipVelocityY = shipVelocityY;
	}

	/**
	 * @return the shipAcceleration
	 */
	public double getShipAcceleration() {
		return shipAcceleration;
	}

	/**
	 * @param shipAcceleration the shipAcceleration to set
	 */
	public void setShipAcceleration(double shipAcceleration) {
		this.shipAcceleration = shipAcceleration;
	}

	/**
	 * @return the fuel
	 */
	public double getFuel() {
		return fuel;
	}

	/**
	 * @param fuel the fuel to set
	 */
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	/**
	 * @return the thrust
	 */
	public double getThrust() {
		return thrust;
	}

	/**
	 * @param thrust the thrust to set
	 */
	public void setThrust(double thrust) {
		this.thrust = thrust;
	}

	/**
	 * @return the rotation
	 */
	public double getRotation() {
		return rotation;
	}

	/**
	 * @param rotation the rotation to set
	 */
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	/**
	 * @return the velocity
	 */
	public double getVelocity() {
		return velocity;
	}

	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(double velocity) {
		this.velocity = velocity;
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
}
