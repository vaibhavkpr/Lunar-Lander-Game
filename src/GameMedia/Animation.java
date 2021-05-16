package GameMedia;

import java.awt.image.BufferedImage;

public class Animation {
	
	private BufferedImage [] frames;	// Load all the frames to simulate animation
	private int currentFrame;			// Keep track of frame being played
	
	private long startTime;				// Timer variable
	private long delay;					// Time between Frames
	
	private boolean played;		// To track whether the frame has been played on the screen
	
	public Animation() {
		setPlayed(false);	
	}
	
	// Determines which frame needs to be playing
	public void update() {
		
		// No Frames
		if(delay < 0) {
			return;
		}
		
		long elapsed = (System.nanoTime() - startTime) / 1000000;
		
		// Move to next frame if frame time completed
		if(elapsed > delay) {
			currentFrame++;
			startTime = System.nanoTime();
		}
		
		// Check end of animation frames
		if(currentFrame == frames.length) {
			currentFrame = 0;
			played = true;
		}
	}
	
	/**
	 * @return the frames
	 */
	public BufferedImage [] getFrames() {
		return frames;
	}

	/**
	 * @param frames the frames to set
	 */
	public void setFrames(BufferedImage [] frames) {
		this.frames = frames;
		currentFrame = 0;
		startTime = System.nanoTime();
		played = false;
	}

	/**
	 * @return the currentFrame
	 */
	public int getCurrentFrame() {
		return currentFrame;
	}

	/**
	 * @param currentFrame the currentFrame to set
	 */
	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the delay
	 */
	public long getDelay() {
		return delay;
	}

	/**
	 * @param delay the delay to set
	 */
	public void setDelay(long delay) {
		this.delay = delay;
	}

	/**
	 * @return the framePlayed
	 */
	public boolean isPlayed() {
		return played;
	}

	/**
	 * @param framePlayed the framePlayed to set
	 */
	public void setPlayed(boolean played) {
		this.played = played;
	}
	
}
