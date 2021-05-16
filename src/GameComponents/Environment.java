package GameComponents;
public class Environment {
	private double gravity;
	private double issLocationX;
	private double issLocationY;
	private double padLocationX;
	private double padLocationY;
	private Asteroid [] asteroids;
	private int asteroidCount = 3;
	
	public Environment() {
		setIssLocationX(120);
		setIssLocationY(25);
		setGravity(0);
		asteroids = new Asteroid[asteroidCount];
		for(int i=0; i<asteroids.length; i++) {
			asteroids[i] = new Asteroid();
		}
	}

	/**
	 * @return the gravity
	 */
	public double getGravity() {
		return gravity;
	}

	/**
	 * @param d the gravity to set
	 */
	public void setGravity(double d) {
		this.gravity = d;
	}

	/**
	 * @return the issLocationX
	 */
	public double getIssLocationX() {
		return issLocationX;
	}

	/**
	 * @param issLocationX the issLocationX to set
	 */
	public void setIssLocationX(double issLocationX) {
		this.issLocationX = issLocationX;
	}

	/**
	 * @return the issLocationY
	 */
	public double getIssLocationY() {
		return issLocationY;
	}

	/**
	 * @param issLocationY the issLocationY to set
	 */
	public void setIssLocationY(double issLocationY) {
		this.issLocationY = issLocationY;
	}

	/**
	 * @return the asteroids
	 */
	public Asteroid [] getAsteroids() {
		return asteroids;
	}

	/**
	 * @param asteroids the asteroids to set
	 */
	public void setAsteroids(Asteroid [] asteroids) {
		this.asteroids = asteroids;
	}

	/**
	 * @return the padLocationX
	 */
	public double getPadLocationX() {
		return padLocationX;
	}

	/**
	 * @param padLocationX the padLocationX to set
	 */
	public void setPadLocationX(double padLocationX) {
		this.padLocationX = padLocationX;
	}

	/**
	 * @return the padLocationY
	 */
	public double getPadLocationY() {
		return padLocationY;
	}

	/**
	 * @param padLocationY the padLocationY to set
	 */
	public void setPadLocationY(double padLocationY) {
		this.padLocationY = padLocationY;
	}
}
