package tankdemo;

import processing.core.PApplet;

/**
 * Represents a tank robot.
 */
public class Tank {
	
	/** Location measured in pixels. */
	private float x = 100, y = 100;
	
	/** Angle in degrees. */
	private float angle = 0;

	/** Speed in pixels per second. */
	private float forwardSpeed = 0;
	
	/** Maximum speed in pixels per second. */
	static final float MAXIMUM_SPEED = 50;
	
	/** Rotational speed in degrees per second. */
	private float turnSpeed = 0;
	
	/** Maximum rotational speed in degrees per second. */
	static final float MAXIMUM_TURN_SPEED = 45;
	
	/** Applet window on which the tank is drawn. */
	private final PApplet canvas;
	
	/** Construct a new Tank. */
	public Tank(PApplet c) {
		canvas = c;
	}
	
	
	/**
	 * Move the tank and then draw it.
	 * @param dt time since the last run, measured in seconds.
	 */
	public void run(float dt) {
		// Move the tank
		angle = angle + (dt * turnSpeed);
		x = x + (dt * forwardSpeed * PApplet.cos(PApplet.radians(angle)));
		y = y + (dt * forwardSpeed * PApplet.sin(PApplet.radians(angle)));
		
		// Draw the tank.
		canvas.pushMatrix();
		canvas.translate(x, y);
		canvas.rotate(PApplet.radians(angle));
		canvas.translate(-x, -y);
		canvas.fill(255, 255, 255);
		canvas.rect(x-15, y-15, 30, 8);
		canvas.rect(x-15, y+8, 30, 8);
		canvas.rect(x-10, y-10, 20, 20);
		canvas.rect(x-3, y-3, 25, 6);
		canvas.popMatrix();
	}
	
	/**
	 * Set the current speed moving forward.
	 * @param s Speed in pixels per second.  May be positive or negative.
	 */
	public void setSpeed(float s)  {
		if (s > MAXIMUM_SPEED) { s = MAXIMUM_SPEED; }
		if (s < -1 * MAXIMUM_SPEED) { s = -1 * MAXIMUM_SPEED; }
		forwardSpeed = s;
	}
	
	/**
	 * Set the current rotational velocity.
	 * @param s Rotational speed in degrees per second.  May be positive or negative.
	 */
	public void turn(float s) {
		if (s > MAXIMUM_TURN_SPEED) { s = MAXIMUM_TURN_SPEED; }
		if (s < -1 * MAXIMUM_TURN_SPEED) { s = -1 * MAXIMUM_TURN_SPEED; }
		turnSpeed = s;
	}
}
