package GameComponents;

public class Asteroid {
	private double aLocationX;
	private double aLocationY;
	private double aVelocityX;
	private double aVelocityY;	
	private double [][] asteroidStartingCoodinatesX = {{0, 5}, {800, 790}, {-100, -95}};
	private double [][] asteroidStartingCoodinatesY = {{200, 310}, {165, 295}};
	private double [][] asteroidStartingVelocityX = {{0.9, 1.35}, {-0.9, -1.35}};
	private double [][] asteroidStartingVelocityY = {{0.45, 0.65}, {0.5, 0.7}};
	
	// Default Asteroid Constructor
	public Asteroid() {
		setaLocationX(asteroidStartingCoodinatesX[randomNumGenerator(0,asteroidStartingCoodinatesX.length-1)][randomNumGenerator(0,asteroidStartingCoodinatesX[0].length-1)]);
		setaLocationY(asteroidStartingCoodinatesY[randomNumGenerator(0,asteroidStartingCoodinatesY.length-1)][randomNumGenerator(0,asteroidStartingCoodinatesY[0].length-1)]);
		if(getaLocationX() > 0) {
			setaVelocityX(asteroidStartingVelocityX[0][randomNumGenerator(0,asteroidStartingVelocityX[0].length-1)]);
		}
		else {
			setaVelocityX(asteroidStartingVelocityX[1][randomNumGenerator(0,asteroidStartingVelocityX[1].length-1)]);
		}
		
		setaVelocityY(asteroidStartingVelocityY[randomNumGenerator(0,asteroidStartingVelocityY.length-1)][randomNumGenerator(0,asteroidStartingVelocityY[0].length-1)]);
	}
	

	// Returns random number within specified range
	public int randomNumGenerator(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));		
	}

	/**
	 * @return the aLocationX
	 */
	public double getaLocationX() {
		return aLocationX;
	}

	/**
	 * @param aLocationX the aLocationX to set
	 */
	public void setaLocationX(double aLocationX) {
		this.aLocationX = aLocationX;
	}

	/**
	 * @return the aLocationY
	 */
	public double getaLocationY() {
		return aLocationY;
	}

	/**
	 * @param aLocationY the aLocationY to set
	 */
	public void setaLocationY(double aLocationY) {
		this.aLocationY = aLocationY;
	}

	/**
	 * @return the aVelocityX
	 */
	public double getaVelocityX() {
		return aVelocityX;
	}

	/**
	 * @param aVelocityX the aVelocityX to set
	 */
	public void setaVelocityX(double aVelocityX) {
		this.aVelocityX = aVelocityX;
	}

	/**
	 * @return the aVelocityY
	 */
	public double getaVelocityY() {
		return aVelocityY;
	}

	/**
	 * @param aVelocityY the aVelocityY to set
	 */
	public void setaVelocityY(double aVelocityY) {
		this.aVelocityY = aVelocityY;
	}
}
