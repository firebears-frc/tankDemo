package tankdemo;

import processing.core.PApplet;

/**
 * Sample Processing Applet that just drives the tank around with the WASD keys.
 */
public class TankDemo extends PApplet {

	Tank tank;
	float time;
	
	public void setup() {
		size(640,480);
		tank = new Tank(this);
		time = millis();
	}

	public void draw() {
		background(128, 128, 128);
		tank.run((millis() - time) / 1000.0f);
		time = millis();

		if (keyPressed) {
			if (key=='w') {
				tank.setSpeed(40);
			} else if (key == 's') {
				tank.setSpeed(-40);
			} else if (key == 'a') {
				tank.turn(-30);
			} else if (key == 'd') {
				tank.turn(30);
			}
		} else {
			tank.setSpeed(0);
			tank.turn(0);
		}
	}
}
