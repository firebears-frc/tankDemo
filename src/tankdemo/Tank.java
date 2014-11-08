package tankdemo;

import processing.core.PApplet;

/**
 * Represents a tank robot.
 */
public class Tank extends ArenaObject {

	/** Applet window on which this object is drawn. */
	private final TankDemo canvas;

    /** Angle that the tank is pointing at, measured in degrees. */
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
		width = 30;
		height = 30;
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
        canvas.translate((x + width/2), (y + height/2));
        canvas.rotate(PApplet.radians(angle));
        canvas.translate(-(x + width/2), -(y + height/2));
        canvas.fill(255, 255, 255);
        canvas.rect(x, y, 30, 8);
        canvas.rect(x, y + 23, 30, 8);
        canvas.rect(x + 5, y +5, 20, 20);
        canvas.rect(x + 12, y +12, 25, 6);
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
	
}
