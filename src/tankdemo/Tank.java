package tankdemo;

import processing.core.PApplet;

/**
 * Represents a tank robot.
 */
public class Tank implements ArenaObject {

	/** Applet window on which this object is drawn. */
	private final TankDemo canvas;
	
	/** Location measured in pixels of the center of this object s. */
	private float x = 100, y = 100, w = 30;

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

	/** Construct a new Tank. */
	public Tank(TankDemo c) {
		canvas = c;
	}

	/**
	 * Move the tank and then draw it.
	 * 
	 * @param dt time since the last run, measured in seconds.
	 */
	public boolean run(float dt) {
		// Move this object
		angle = angle + (dt * turnSpeed);
		x = x + (dt * forwardSpeed * PApplet.cos(PApplet.radians(angle)));
		y = y + (dt * forwardSpeed * PApplet.sin(PApplet.radians(angle)));

		// Draw this object
		canvas.pushMatrix();
		canvas.translate(x, y);
		canvas.rotate(PApplet.radians(angle));
		canvas.translate(-x, -y);
		canvas.fill(255, 255, 255);
		canvas.rect(x - 15, y - 15, 30, 8);
		canvas.rect(x - 15, y + 8, 30, 8);
		canvas.rect(x - 10, y - 10, 20, 20);
		canvas.rect(x - 3, y - 3, 25, 6);
		canvas.popMatrix();
		
		return true;
	}

	/**
	 * Set the current speed moving forward.
	 * 
	 * @param s Speed in pixels per second. May be positive or negative.
	 */
	public void setSpeed(float s) {
		if (s > MAXIMUM_SPEED) {
			s = MAXIMUM_SPEED;
		}
		if (s < -1 * MAXIMUM_SPEED) {
			s = -1 * MAXIMUM_SPEED;
		}
		forwardSpeed = s;
	}

	/**
	 * Set the current rotational velocity.
	 * 
	 * @param s Rotational speed in degrees per second. May be positive or negative.
	 */
	public void turn(float s) {
		if (s > MAXIMUM_TURN_SPEED) {
			s = MAXIMUM_TURN_SPEED;
		}
		if (s < -1 * MAXIMUM_TURN_SPEED) {
			s = -1 * MAXIMUM_TURN_SPEED;
		}
		turnSpeed = s;
	}

	/**
	 * @return the current angle in degrees.
	 */
	public float getAngle() {
		return angle;
	}

	/**
	 * @return the current horizontal position in pixels from the left edge of
	 *         the screen to this object's leftmost edge.
	 */
	public float getX() {
		return x-w/2;
	}

	/**
	 * @return the current vertical position in pixels from the top edge of the
	 *         screen to this object's top edge.
	 */
	public float getY() {
		return y-w/2;
	}

	/**
	 * @return width of this object in pixels.
	 */
	public float getWidth() {
		return w;
	}

	/**
	 * @return height of this object in pixels.
	 */
	public float getHeight() {
		return w;
	}
	
	/** @return whether this {@link Tank} intersects with the other. */
	public boolean intersects(ArenaObject other) {
		if (this.getX() + this.getWidth() < other.getX()) {
			// This tank is too far to the left of the other object
			return false;
		}
		if (this.getX() > other.getX() + other.getWidth()) {
			// This tank is too far to the right of the other object
			return false;
		}
		if (this.getY() + this.getHeight() < other.getY()) {
			// This tank is too far above the other object
			return false;
		}
		if (this.getY() > other.getY() + other.getHeight()) {
			// This tank is too far below the other object
			return false;
		}
		return true;
	}
	
}
