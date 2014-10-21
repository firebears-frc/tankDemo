package tankdemo;

import processing.core.PApplet;

/**
 * Sample Processing Applet that just drives the tank around with the WASD keys.
 */
public class TankDemo extends PApplet {

	Tank tank;
	float timePrevious;
	int state = 0;
	
	public void setup() {
		size(640,480);
		tank = new Tank(this);
		timePrevious = millis();
	}

	public void draw() {
		background(128, 128, 128);
		long timeNow = millis();
		tank.run((timeNow - timePrevious) / 1000.0f);
		timePrevious = timeNow;

		if (keyPressed) {
			state = 0;
			if (key=='w') {
				tank.setSpeed(40);
			} else if (key == 's') {
				tank.setSpeed(-40);
			} else if (key == 'a') {
				tank.turn(-30);
			} else if (key == 'd') {
				tank.turn(30);
			} else if (key == '1') {
				state = 1;
			}
		} else if (state == 1) {
			// Do something different in state 1
		} else {
			tank.setSpeed(0);
			tank.turn(0);
			state = 0;
		}
	}
}
